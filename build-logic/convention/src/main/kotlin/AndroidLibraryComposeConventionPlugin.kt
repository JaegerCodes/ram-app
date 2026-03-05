import com.android.build.api.dsl.LibraryExtension
import com.arkamo.rickandmorty.configureAndroidCompose
import com.arkamo.rickandmorty.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig {
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            dependencies {
                add("androidTestImplementation", project(":core:testing-android"))
                add("testImplementation", project(":core:testing-android"))
            }
        }
    }
}
