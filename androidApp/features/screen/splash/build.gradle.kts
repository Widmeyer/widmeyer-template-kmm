plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "com.widmeyertemplate.screen.splash"
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

    defaultConfig {
        minSdk = 26
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared.core)
    implementation(projects.shared.resources)
    implementation(projects.shared.entity)
    implementation(projects.shared.features.base)
    implementation(projects.shared.features.splash)
    implementation(projects.shared.features.root)
    implementation(projects.androidApp.ui)

    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin.android)
    implementation(libs.bundles.moko.mvvm)
    implementation(libs.mokoNetworkErrors)
    implementation(libs.kotlinSerialization)
    implementation(libs.compose.navigation)

    debugImplementation(libs.compose.ui.tooling.preview)
}