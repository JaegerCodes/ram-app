plugins {
    id("arkamo.android.feature.presentation")
}

android {
    namespace = "com.arkamo.rickandmorty.feature.character.presentation"
}

dependencies {
    implementation(project(":feature:character:domain"))
    // koin-androidx-compose provides koinViewModel() for Composable functions
    implementation("io.insert-koin:koin-androidx-compose:4.1.1")
}
