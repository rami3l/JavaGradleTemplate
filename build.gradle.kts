plugins {
  id("application")
  id("eclipse")

  id("net.ltgt.errorprone") version "3.0.1"
  id("net.ltgt.nullaway") version "1.5.0"

  id("se.patrikerdes.use-latest-versions") version "0.2.18"
  id("com.github.ben-manes.versions") version "0.44.0"

  id("com.diffplug.spotless") version "6.13.0"
}

repositories { mavenCentral() }

dependencies {
  implementation("com.google.guava:guava:31.1-jre")
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
  errorprone("com.google.errorprone:error_prone_core:2.18.0")
  errorprone("com.uber.nullaway:nullaway:0.10.8")
}

nullaway { annotatedPackages.add("JavaGradleTemplate") }

spotless {
  java { googleJavaFormat() }
  kotlinGradle {
    target("*.gradle.kts")
    ktlint()
      .editorConfigOverride(mapOf("indent_size" to 2))
  }
  groovyGradle { target("*.gradle") }
}

application {
  // Define the main class for the application.
  mainClass.set("JavaGradleTemplate.App")
}

tasks.withType<JavaCompile> { options.compilerArgs.addAll(arrayOf("--enable-preview")) }

tasks.withType<Test>().all {
  jvmArgs("--enable-preview")
  useJUnitPlatform()
}
