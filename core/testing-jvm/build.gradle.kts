plugins {
    id("arkamo.kotlin.library")
}

dependencies {
    api(libs.junit)
    api(libs.kotlin.test.junit)
    api(libs.mockk.agent)
    api(libs.mockk)
    api(libs.kotlinx.coroutines.test)
}
