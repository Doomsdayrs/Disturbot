import java.io.FileInputStream
import java.util.*

plugins {
    application
    java
    kotlin("jvm") version "1.3.72"
    id("com.github.gmazzo.buildconfig") version "2.0.1"
    id("org.openjfx.javafxplugin") version "0.0.8"
}

group = "com.revolutionarygamesstudio"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/exposed")
}
buildConfig {
    buildConfigField("String", "discordToken", "\"${getProps()["discordToken"]}\"")
}

javafx {
    version = "11.0.2"
    modules = listOf("javafx.controls", "javafx.graphics")
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.3.7")

    // Database
    implementation("org.jetbrains.exposed:exposed-core:0.24.1")

    // Discord API Wrapper
    implementation("com.discord4j:discord4j-core:3.1.0.RC1")

    // Kodein
    implementation("org.kodein.di:kodein-di-generic-jvm:6.5.0")

    // tornadoFX
    implementation("no.tornado:tornadofx:1.7.20")

    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

fun getProps(): Properties {
    val props = Properties()
    props.load(FileInputStream(file(".gradle/gradle.properties")))
    return props
}