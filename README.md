# Rick & Morty App

Aplicación Android desarrollada como challenge técnico. Consume la [Rick and Morty API](https://rickandmortyapi.com/) y muestra un listado de personajes con su nombre, especie y estado vital.

---

## Arquitectura

El proyecto sigue una arquitectura **multi-módulo limpia** dividida en tres capas por feature:

```
app/
core/
  ├── network/          # Retrofit, OkHttp, manejo de respuestas HTTP
  ├── testing-android/  # Dependencias de test para módulos Android
  └── testing-jvm/      # Dependencias de test para módulos Kotlin puros
ram-ui/                 # Design system (tema, colores, tipografía, dimensiones)
feature/
  └── character/
        ├── domain/     # Modelos, repositorio (interfaz), casos de uso
        ├── data/       # Implementación del repositorio, DTOs, Retrofit service
        └── presentation/ # ViewModel (MVI), Composables, navegación
build-logic/
  └── convention/       # Plugins de convención de Gradle
```

**Patrón de presentación:** MVI (Model–View–Intent) con `StateFlow` como fuente única de verdad de la UI.

---

## Decisiones técnicas

### build-logic como SSOT de configuración Gradle

Se creó el módulo `build-logic` con plugins de convención personalizados para centralizar toda la configuración de Gradle en un único lugar (Single Source of Truth).

Cada tipo de módulo tiene su propio plugin:

| Plugin | Id | Uso |
|---|---|---|
| `AndroidLibraryConventionPlugin` | `arkamo.android.library` | Módulos Android sin Compose |
| `AndroidLibraryComposeConventionPlugin` | `arkamo.android.library.compose` | Módulos Android con Compose |
| `AndroidApplicationConventionPlugin` | `arkamo.android.application` | Módulo `:app` |
| `AndroidApplicationComposeConventionPlugin` | `arkamo.android.compose` | `:app` con Compose |
| `KotlinLibraryConventionPlugin` | `arkamo.kotlin.library` | Módulos Kotlin puros (sin Android) |
| `AndroidFeatureDataConventionPlugin` | `arkamo.android.feature.data` | Módulos de capa data |
| `KotlinFeatureDomainConventionPlugin` | `arkamo.kotlin.feature.domain` | Módulos de capa domain |
| `AndroidFeaturePresentationConventionPlugin` | `arkamo.android.feature.presentation` | Módulos de capa presentation |

**¿Por qué este enfoque?**
- Evita duplicar `compileSdk`, `minSdk`, versiones de librerías y configuración de Compose en cada `build.gradle.kts`.
- Un solo cambio en el plugin se propaga a todos los módulos que lo usan.
- El `libs.versions.toml` centraliza todas las versiones como catálogo de versiones de Gradle (también SSOT).
- Escala bien: agregar un nuevo feature module solo requiere aplicar el plugin correspondiente.

### Design system (ram-ui)

Módulo independiente que expone tokens de diseño (colores, tipografía, dimensiones) a través de `CompositionLocal`. El acceso se realiza mediante `RamTheme.colors`, `RamTheme.typography` y `RamTheme.dimensions`, lo que desacopla los valores visuales del código de UI.

### Inyección de dependencias

Se usa **Koin** por su simplicidad y compatibilidad con Kotlin/Compose. Cada módulo declara su propio módulo Koin (`characterDataModule`, `characterDomainModule`, `characterPresentationModule`) y el `:app` los registra al arrancar.

### Manejo de red

`apiCall` en `core:network` es una función suspendida genérica que envuelve las llamadas Retrofit en un `Result<T>`, eliminando la necesidad de try/catch en cada repositorio.

---

## Stack tecnológico

- **Kotlin** + **Coroutines** + **StateFlow**
- **Jetpack Compose** + **Navigation Compose**
- **Retrofit** + **Moshi** (serialización JSON)
- **Coil** (carga de imágenes)
- **Koin** (inyección de dependencias)
- **MockK** (mocking en tests)
- **kotlinx-coroutines-test** (tests de coroutines)
- **Compose UI Test** (tests instrumentados)

---

## Tests

### Unitarios
| Clase | Módulo | Qué prueba |
|---|---|---|
| `CharacterDtoTest` | `feature:character:data` | Mapper `toDomain()`: campos, estados, case-insensitive |
| `CharacterRepositoryImplTest` | `feature:character:data` | Éxito, error HTTP, body nulo, excepción de red |
| `GetCharactersUseCaseTest` | `feature:character:domain` | Delegación al repositorio, resultado éxito/fallo |
| `CharacterViewModelTest` | `feature:character:presentation` | Estado Loading/Success/Error, intents LoadCharacters y Retry |

### Instrumentados
| Clase | Módulo | Qué prueba |
|---|---|---|
| `CharacterListScreenTest` | `feature:character:presentation` | Renderizado de cada estado UI, click en Retry |

---

## Qué quedó fuera por falta de tiempo

- **ktlint** — linter de estilo de código Kotlin. Se habría configurado como plugin en `build-logic` para que todos los módulos lo hereden automáticamente.
- **Detekt** — análisis estático. Permitiría detectar code smells, complejidad ciclomática y código duplicado de forma continua.

Ambas herramientas se integrarían en el pipeline de CI para que fallen el build si no se cumplen las reglas.

---

## Qué mejoraría con más tiempo

- **Pantalla de detalle** — navegar al detalle de un personaje al tocar un item de la lista, consumiendo el endpoint `/character/{id}` de la API.
- **Git hooks** — configurar un pre-commit hook (via Gradle o con la librería `git-hooks-gradle`) que ejecute ktlint y los tests unitarios antes de cada commit, evitando que código con errores llegue al repositorio.
- **Paginación** — integrar `Paging 3` para cargar los personajes de forma incremental en lugar de traer toda la lista de una sola vez.

---

## Uso de inteligencia artificial

Se utilizó IA (Claude) como asistente en las siguientes partes del desarrollo:

- **Plugins de convención de Gradle** — co-creación de los plugins.
- **Tests unitarios** — generación de `CharacterDtoTest`, `CharacterRepositoryImplTest`, `GetCharactersUseCaseTest` y `CharacterViewModelTest`. Se revisó cada test generado para validar que los casos cubrieran el comportamiento real del código.
- **Tests instrumentados** — generación de `CharacterListScreenTest` con Compose Test Rule, incluyendo la estrategia de pasar el ViewModel directamente para evitar la dependencia de Koin en los tests.

