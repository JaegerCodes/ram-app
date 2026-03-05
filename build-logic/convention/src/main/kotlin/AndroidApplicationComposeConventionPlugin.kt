import com.android.build.api.dsl.ApplicationExtension
import com.arkamo.rickandmorty.configureAndroidCompose
import com.arkamo.rickandmorty.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig {
                    minSdk = 24
                }
            }
        }
    }
}
