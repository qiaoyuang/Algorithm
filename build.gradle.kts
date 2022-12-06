plugins {
    kotlin("multiplatform") version "1.7.20"
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
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }

    nativeTarget.apply {
        binaries {
            target.compilations["main"].kotlinOptions.freeCompilerArgs += listOf("-Xruntime-logs=gc=info")
            executable {
                entryPoint = "main"
                // runTask?.args("")
            }
        }
    }

    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }
}
