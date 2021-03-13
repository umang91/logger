plugins {
  id("com.android.library")
  id("kotlin-android")
}

android {
  compileSdkVersion(29)

  defaultConfig {
    minSdkVersion(16)
    targetSdkVersion(29)

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  kotlinOptions.apply {
    jvmTarget = JavaVersion.VERSION_1_8.toString()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

}

dependencies {
  implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

  implementation("androidx.annotation:annotation:1.1.0")
  implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra.get("kotlinVersion")}")
}