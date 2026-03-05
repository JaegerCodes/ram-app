plugins {
    id("arkamo.android.compose")
}

android {
    namespace = "com.arkamo.rickandmorty.designsystem"
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.compose.navigation)
    implementation(libs.material)
    api(libs.coil)
}
