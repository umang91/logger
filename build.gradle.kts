// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

  extra.set("kotlinVersion", "1.4.31")

  repositories {
    google()
    mavenCentral()
    jcenter()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.1.2")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra.get("kotlinVersion")}")

  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
    jcenter()
  }
}

tasks.register < Delete > ("clean") {
  delete(rootProject.buildDir)
}