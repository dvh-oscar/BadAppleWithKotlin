plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "com.danvhae.oscar.console.badapple"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.log4j.api)
    implementation(libs.log4j.core)
    implementation(libs.log4j.impl)
    implementation(libs.slf4j.api)
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}