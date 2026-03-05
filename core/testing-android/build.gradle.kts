plugins {
    id("arkamo.android.library")
}

android {
    namespace = "com.arkamo.spy.core.testing.android"
}

dependencies {
    api(project(":core:testing-jvm"))
    api(libs.androidx.test.ext)
    api(libs.androidx.test.espresso)
    api(libs.mockk.android)
}