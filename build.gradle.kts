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
//    implementation(libs.log4j.api)
//    implementation(libs.log4j.core)
//    implementation(libs.log4j.impl)
//    implementation(libs.slf4j.api)

    implementation(libs.java.cv)
    implementation("com.github.ajalt.clikt:clikt:5.0.1")

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


tasks.build{
    dependsOn(tasks.shadowJar)

}

tasks.jar{
    manifest{
        attributes["Main-Class"] = "com.danvhae.oscar.console.badapple.App"
    }
}

tasks.shadowJar{
    archiveFileName.set("${project.name}.jar")
}