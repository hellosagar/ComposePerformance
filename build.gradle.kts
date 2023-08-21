// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidApplication) apply false
  alias(libs.plugins.kotlinAndroid) apply false
}
true // Needed to make the Suppress annotation work for the plugins block

subprojects {
  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
      freeCompilerArgs += listOf(
        "-P",
        "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=" +
          project.buildDir.absolutePath + "/compose_compiler"
      )
      freeCompilerArgs += listOf(
        "-P",
        "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=" +
          project.buildDir.absolutePath + "/compose_compiler"
      )
    }
  }
}
