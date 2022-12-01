import org.gradle.api.plugins.JavaPlugin.TEST_IMPLEMENTATION_CONFIGURATION_NAME
import org.gradle.api.plugins.JavaPlugin.TEST_RUNTIME_CLASSPATH_CONFIGURATION_NAME
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.7.20"
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
    mavenCentral()
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
    getByName("systemTestImplementation").extendsFrom(configurations.getByName(TEST_IMPLEMENTATION_CONFIGURATION_NAME))
    getByName("systemTestRuntimeOnly").extendsFrom(configurations.getByName(TEST_RUNTIME_CLASSPATH_CONFIGURATION_NAME))
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
    implementation(kotlin("reflect"))
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

    // Logging
    val log4jVersion = "2.17.2"
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")

    testImplementation("org.assertj:assertj-core:3.15.0")

    // mockito
    val mockitoVersion = "4.4.0"
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-inline:$mockitoVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    // junit
    val junitVersion = "5.8.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
  }
}


