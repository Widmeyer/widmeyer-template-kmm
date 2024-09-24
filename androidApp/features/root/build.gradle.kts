plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.composeCompiler)
}

android {
    namespace = "com.widmeyertemplate.features.root"
    compileSdk = 34

    buildFeatures {
        compose = true
    }

    defaultConfig {
        minSdk = 24
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
    projects.androidApp.features.screen.splash,
)

val sharedModules = listOf(
    projects.shared.features.root,
    projects.shared.features.base,
    projects.shared.entity,
    projects.shared,
)

dependencies {
    featureModules.forEach { module ->
        implementation(module)
    }

    sharedModules.forEach { module ->
        implementation(module)
    }

    implementation(libs.mokoMvvmCore)
    implementation(libs.mokoMvvmFlow)
    implementation(libs.mokoMvvmLiveData)
    implementation(libs.androidx.core.ktx)
    implementation(libs.compose.navigation)
    implementation(libs.material)
    implementation(libs.koinCore)
    implementation(libs.koinAndroid)
}