plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "com.widmeyertemplate.features.root"
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
        compose = true
    }

    defaultConfig {
        minSdk = 26
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val featureModules = listOf(
    projects.androidApp.ui,
    projects.androidApp.features.screen.splash
)

val sharedModules = listOf(
    projects.shared.core,
    projects.shared.entity,
    projects.shared.features.base,
    projects.shared.features.root,
    projects.shared.features.splash
)

dependencies {
    featureModules.forEach { module ->
        implementation(module)
    }

    sharedModules.forEach { module ->
        implementation(module)
    }

    implementation(libs.bundles.android)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.koin.android)
    implementation(libs.bundles.moko.mvvm)
    implementation(libs.mokoNetworkErrors)
    implementation(libs.compose.navigation)
    implementation(libs.kotlinSerialization)
    implementation(libs.compose.navigation)

    debugImplementation(libs.compose.ui.tooling.preview)
}