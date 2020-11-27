plugins {
    kotlin("jvm") version "1.4.20"
    application
    id("org.jmailen.kotlinter") version "3.2.0"
}

group = "com.s2tek"
version = "1.0"

application {
    mainClassName = "com.s2tek.MainKt"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))
}

tasks.test {
    useJUnit()
}

tasks.check {
    dependsOn("installKotlinterPrePushHook")
}
