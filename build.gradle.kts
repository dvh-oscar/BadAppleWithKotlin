plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.shadow)
}

group = "com.danvhae.oscar.console.badapple"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutine)
    implementation(libs.log4j.api)
    implementation(libs.log4j.core)
    implementation(libs.log4j.impl)
    implementation(libs.slf4j.api)

    implementation(libs.java.cv)
    testImplementation(libs.java.cv)
    testImplementation(libs.kotlin.stdlib)
    testImplementation(libs.kotlin.coroutine)
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}