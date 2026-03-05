plugins {
    id("arkamo.android.application")
}

android {
    namespace = "com.arkamo.rickandmorty"

    defaultConfig {
        applicationId = "com.arkamo.rickandmorty"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":ram-ui"))
    implementation(project(":feature:character:data"))
    implementation(project(":feature:character:domain"))
    implementation(project(":feature:character:presentation"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Navigation (NavHost lives in the app module)
    implementation(libs.compose.navigation)

    // Koin
    implementation(libs.koin.android)

    testImplementation(libs.junit)
}