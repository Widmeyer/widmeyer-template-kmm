plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget()
    kotlin {
        jvmToolchain(21)
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "base"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.entity)
            implementation(projects.shared.resources)

            implementation(libs.bundles.ktor)
            implementation(libs.bundles.viewmodel)

            implementation(libs.kotlinSerialization)
        }
    }
}

android {
    namespace = "com.features.base"
    compileSdk = 36
    defaultConfig {
        minSdk = 26
    }

}