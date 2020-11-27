plugins {
    kotlin("jvm") version "1.4.20"
    application
    jacoco
    id("org.jmailen.kotlinter") version "3.2.0"
    id("com.github.jakemarsden.git-hooks") version "0.0.2"
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
    finalizedBy(tasks.jacocoTestReport)
}

tasks.check {
    dependsOn("installKotlinterPrePushHook")
}

tasks.jacocoTestReport {
    reports {
        html.destination = file("coverage")
    }
}

gitHooks {
    setHooks(mapOf("pre-commit" to "check test --parallel"))
}
