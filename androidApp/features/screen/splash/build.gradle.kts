plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.composeCompiler)
}

android {
    namespace = "com.widmeyertemplate.screen.splash"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
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
    implementation(projects.shared)
    implementation(projects.shared.resources)
    implementation(projects.shared.entity)
    implementation(projects.shared.features.base)
    implementation(projects.shared.features.splash)
    implementation(projects.shared.features.root)
    implementation(projects.androidApp.ui)

    implementation(libs.koinCore)
    implementation(libs.koinAndroid)
    implementation(libs.mokoNetworkErrors)
    implementation(libs.mokoMvvmCore)
    implementation(libs.mokoMvvmFlow)
    implementation(libs.mokoMvvmLiveData)

    implementation(libs.androidx.core.ktx)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
}