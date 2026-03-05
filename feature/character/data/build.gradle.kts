plugins {
    id("arkamo.android.feature.data")
}

android {
    namespace = "com.arkamo.rickandmorty.feature.character.data"
}

dependencies {
    implementation(project(":feature:character:domain"))
}
