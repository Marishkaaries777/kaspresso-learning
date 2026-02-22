plugins {
    kotlin("jvm") version "2.3.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.hamcrest:hamcrest:2.2")
}

kotlin {
    jvmToolchain(11)
}

tasks.test {
    useJUnitPlatform()
}