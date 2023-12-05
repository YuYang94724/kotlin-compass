plugins {
    kotlin("jvm") version "1.9.0"
    application
    `maven-publish`
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
//    testImplementation(kotlin("test"))
    // Use JUnit Jupiter for testing.
//    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    // This dependency is used by the application.
//    implementation("com.google.guava:guava:32.1.2-jre")
//    implementation("com.google.guava:guava:30.0-jre")

    testImplementation(libs.junit)
    implementation(libs.guava)
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
//    jvmToolchain(17)
    jvmToolchain{
        languageVersion.set(JavaLanguageVersion.of(17))
    }

}

application {
    mainClass.set("MainKt")
}

tasks.register("hello") {
    doLast {
        println("Hello!")
    }
}

tasks.register("greet") {
    doLast {
        println("How are you?")
    }
    dependsOn("hello")
}

tasks.register("good") {
    doLast {
        println("You're good! ")
    }
    dependsOn("greet")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.gradle.tutorial"
            artifactId = "tutorial"
            version = "1.0"

            from(components["java"])
        }
    }
}