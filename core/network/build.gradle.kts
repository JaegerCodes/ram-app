plugins {
    id("arkamo.android.library")
}

android {
    namespace = "com.arkamo.rickandmorty.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.koin.android)
    api(libs.squareup.retrofit)
    implementation(libs.squareup.okhttp.logging.interceptor)
    implementation(libs.squareup.retrofit.converter.moshi)
    implementation(libs.squareup.moshi.kotlin)
}
