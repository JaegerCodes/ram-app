
import com.android.build.api.dsl.ApplicationExtension
import com.arkamo.rickandmorty.configureAndroidCompose
import com.arkamo.rickandmorty.configureKotlinAndroid
import com.arkamo.rickandmorty.loadVersionProperties
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            val versionProperties = loadVersionProperties()

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)

                defaultConfig.apply {
                    minSdk = 24
                    targetSdk = 36
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    versionCode = versionProperties["CODE"].toString().toInt()
                    versionName =
                        "${versionProperties["MAJOR"]}.${versionProperties["MINOR"]}.${versionProperties["PATCH"]}"
                }
            }
        }
    }
}
