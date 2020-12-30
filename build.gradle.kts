import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.4.20"
  id("com.adarshr.test-logger").version("2.0.0")
}

allprojects {

  apply {
    plugin("java")
    plugin("org.jetbrains.kotlin.jvm")
    plugin("com.adarshr.test-logger")
  }

  repositories {
    mavenLocal()
    jcenter()
  }

  java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  sourceSets.create("systemTest") {
    compileClasspath += sourceSets["main"].output + sourceSets["test"].output
    runtimeClasspath += sourceSets["main"].output + sourceSets["test"].output
  }.withConvention(KotlinSourceSet::class) {
    kotlin.srcDir(file("src/system-test/kotlin"))
  }

  configurations {
    getByName("systemTestImplementation").extendsFrom(testImplementation.get())
    getByName("systemTestRuntime").extendsFrom(testRuntime.get())
  }

  tasks {
    // Use the built-in JUnit support of Gradle.
    named<Test>("test") {
      useJUnitPlatform()
    }

    create<Test>("systemTest") {
      useJUnitPlatform()
      testClassesDirs = sourceSets["systemTest"].output.classesDirs
      classpath += sourceSets["systemTest"].runtimeClasspath
      mustRunAfter("test")
    }

    withType(KotlinCompile::class.java).all {
      kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
      }
    }
  }

  dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")

    // Logging
    implementation("org.apache.logging.log4j:log4j-core:2.10.0")
    implementation("org.apache.logging.log4j:log4j-api:2.10.0")

    testImplementation("org.assertj:assertj-core:3.15.0")

    // mockito
    testImplementation("org.mockito:mockito-core:2.28.2")
    testImplementation("org.mockito:mockito-inline:2.28.2")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")

    // junit
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.6.0")
  }
}


