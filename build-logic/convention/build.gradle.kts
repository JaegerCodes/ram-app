plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.ksp.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "arkamo.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "arkamo.android.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "arkamo.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "arkamo.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "arkamo.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("androidFeatureData") {
            id = "arkamo.android.feature.data"
            implementationClass = "AndroidFeatureDataConventionPlugin"
        }
        register("kotlinFeatureDomain") {
            id = "arkamo.kotlin.feature.domain"
            implementationClass = "KotlinFeatureDomainConventionPlugin"
        }
    }
}
