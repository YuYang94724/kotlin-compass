plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "kotlin.travel"
version = "1.0-SNAPSHOT"
sourceSets.main {
    java.srcDirs("src/main/kotlin")
}
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}