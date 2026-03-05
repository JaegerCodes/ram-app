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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Koin
    implementation(libs.koin.android)

    testImplementation(libs.junit)
}