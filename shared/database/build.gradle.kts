import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.sql.delight)
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
            baseName = "database"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.sql.delight.driver)
        }
        commonMain.dependencies {
            implementation(projects.shared.resources)
            implementation(projects.shared.entity)
            implementation(libs.kotlinSerialization)
            implementation(libs.kotlinxDateTime)
            implementation(libs.koinCore)
            implementation(libs.sql.delight.runtime)
            implementation(libs.sql.delight.coroutines)
        }
        iosMain.dependencies {
            implementation(libs.sql.delight.native)
        }
    }
}

android {
    namespace = "com.database"
    compileSdk = 35
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName = "com.database"
        }
    }
}
