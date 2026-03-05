import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureDataConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            pluginManager.apply("arkamo.android.library")

            dependencies {
                add("implementation", libs.findLibrary("koin-android").get())
                add("implementation", project(":core:network"))
                add("implementation", libs.findLibrary("squareup-retrofit").get())
                add("implementation", libs.findLibrary("kotlinx-coroutines-android").get())
                add("implementation", libs.findLibrary("squareup-moshi").get())
                add("implementation", libs.findLibrary("squareup-moshi-kotlin").get())
            }
        }
    }
}