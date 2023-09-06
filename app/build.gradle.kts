@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
  alias(libs.plugins.androidApplication)
  alias(libs.plugins.kotlinAndroid)
  id("com.google.devtools.ksp") version "1.8.10-1.0.9"
}

android {
  namespace = "dev.sagar.composeperformance"
  compileSdk = 34

  defaultConfig {
    applicationId = "dev.sagar.composeperformance"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"
    multiDexEnabled = true

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(libs.core.ktx)
  implementation(libs.lifecycle.runtime.ktx)
  implementation(libs.activity.compose)
  implementation(platform(libs.compose.bom))
  implementation(libs.ui)
  implementation(libs.ui.graphics)
  implementation(libs.ui.tooling.preview)
  implementation(libs.material3)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.test.ext.junit)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(platform(libs.compose.bom))
  androidTestImplementation(libs.ui.test.junit4)
  debugImplementation(libs.ui.tooling)
  debugImplementation(libs.ui.test.manifest)
  implementation(project(":domain"))
  implementation(project(":domainfixed"))

  // Kotlinx immutable collection
  implementation(libs.kotlinx.collections.immutable)

  // Lifeycle Viewmodel compose
  implementation(libs.compose.viewmodel)

  // Kotlin coroutines core
  implementation(libs.coroutines.core)

  // Easy navigation
  implementation("io.github.raamcosta.compose-destinations:core:1.9.52")
  ksp("io.github.raamcosta.compose-destinations:ksp:1.9.52")
}
