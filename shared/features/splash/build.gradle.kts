plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "splash"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.shared.core)
            implementation(projects.shared.entity)
            implementation(projects.shared.network)
            implementation(projects.shared.resources)
            implementation(projects.shared.features.base)

            implementation(libs.bundles.moko.mvvm)
            implementation(libs.bundles.moko.network)
            implementation(libs.bundles.ktor)
            implementation(libs.koinCore)

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.widmeyertemplate.features.splash"
    compileSdk = 35
    defaultConfig {
        minSdk = 26
    }

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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
