plugins {
    kotlin("jvm") version "1.9.21"
    id("net.researchgate.release") version "3.0.2"
}

group = "com.github.csolem.alphanumeric-converter"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
