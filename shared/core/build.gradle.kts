import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
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
            baseName = "core"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.koinCore)
            implementation(libs.koinAndroid)
            implementation(libs.ktorClientOkHttp)
        }
        commonMain.dependencies {
            implementation(projects.shared.entity)
            implementation(projects.shared.database)

            implementation(libs.kotlinSerialization)
            implementation(libs.kotlinxDateTime)
            implementation(libs.koinCore)
            implementation(libs.bundles.ktor)
            implementation(libs.mokoResources)
            implementation(libs.multiplatformSettings)

            implementation(libs.bundles.moko.network)
            implementation(libs.bundles.coil)

        }
        iosMain.dependencies {
            implementation(libs.ktorClientDarwin)
            implementation(libs.koinCore)
        }
    }
}

android {
    namespace = "com.core"
    compileSdk = 35

    buildFeatures.buildConfig = true
    flavorDimensions.add(0, "jni")

    productFlavors {
        create("dev") {
            dimension = "jni"
            buildConfigField("String", "BUILD_TYPE", "\"DEV\"")
        }

        create("prod") {
            dimension = "jni"
            buildConfigField("String", "BUILD_TYPE", "\"PROD\"")
        }
    }

    externalNativeBuild {
        ndkBuild {
            path = file("src/androidMain/kotlin/com/core/jni/Android.mk")
        }
    }

    defaultConfig {
        minSdk = 26
        buildConfigField("int", "VERSION_CODE", "1")
        buildConfigField("String", "VERSION_NAME", "\"1.0.0\"")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
}