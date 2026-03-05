pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Rick And Morty App"
include(":app")
include(":core:network")
include(":core:testing-jvm")
include(":core:testing-android")
include(":ram-ui")
include(":feature:character")
include(":feature:character:data")
include(":feature:character:domain")
include(":feature:character:presentation")
