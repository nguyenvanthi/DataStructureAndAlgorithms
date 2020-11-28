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

gitHooks {
  setHooks(mapOf("pre-commit" to "check test --parallel"))
}

tasks.test {
  useJUnit()
}

tasks.check {
  dependsOn("installKotlinterPrePushHook")
}

tasks.jacocoTestReport {
  dependsOn("test")
  reports {
    csv.isEnabled = true
  }
}

tasks.jacocoTestCoverageVerification {
  violationRules {
    rule {
      limit {
        minimum = "0.9".toBigDecimal()
      }
    }
  }
}
