import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.detekt)
    alias(libs.plugins.benmanes.versions)
}

group = "dev.jamesyox"
version = libs.versions.current.get()

kotlin {
    explicitApi()
    jvm()
    js(IR) {
        nodejs()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.jamesyox.statik.core)
                implementation(libs.jamesyox.statik.markdown)
                implementation(libs.jamesyox.statik.syntax)
            }
        }
        jsMain
    }
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    autoCorrect = true
    config.from(files("$projectDir/detekt/config.yml"))

    dependencies {
        detektPlugins(libs.detekt.formatting)
    }
}

allprojects {
    repositories {
        mavenCentral()
        mavenLocal()
    }
}

tasks.register("allDetekt") {
    allprojects {
        this@register.dependsOn(tasks.withType<Detekt>())
    }
}

tasks.withType<JavaExec> {
    workingDir = file("/home/yoxjames/website")
}
