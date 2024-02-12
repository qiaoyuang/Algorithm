plugins {
    kotlin("multiplatform") version "1.9.22"
}

group = "com.qiaoyuang.algorithm"
version = "1.0"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

kotlin {
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val arch = System.getProperty("os.arch")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> if (arch.contains("x86")) macosX64("native") else macosArm64("native")
        hostOs == "Linux" -> if (arch.contains("x86")) linuxX64("native") else linuxArm64("native")
        isMingwX64 -> mingwX64()
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            executable {
                entryPoint = "com.qiaoyuang.algorithm.main"
                // runTask?.args("")
            }
        }
        compilations.configureEach {
            compilerOptions.configure {
                // freeCompilerArgs.add("-Xbinary=gc=pmc")
            }
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("kotlin.RequiresOptIn")
            }
        }
        val nativeMain by getting {
            dependencies {
                implementation("androidx.collection:collection:1.4.0")
            }
        }
    }
}
