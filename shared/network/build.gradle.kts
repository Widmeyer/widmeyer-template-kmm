import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    id("dev.icerock.mobile.multiplatform-network-generator")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = JvmTarget.JVM_18.target
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "network"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core)
            implementation(projects.shared.entity)
            implementation(projects.shared.features.base)
            implementation(libs.kotlinSerialization)
            implementation(libs.kotlinxDateTime)
            implementation(libs.koinCore)
            implementation(libs.multiplatformSettings)
            implementation(libs.bundles.ktor)
            implementation(libs.bundles.moko.network)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.network"
    compileSdk = 35

    flavorDimensions.add(0, "jni")

    productFlavors {
        create("dev") {
            dimension = "jni"
            matchingFallbacks.add("dev")

        }

        create("prod") {
            dimension = "jni"
            matchingFallbacks.add("prod")
        }
    }

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
}

mokoNetwork {
    spec("serverApi") {
        inputSpec = file("src/commonMain/kotlin/com/network/api/openapi.yml")
        isInternal = false
    }
}
