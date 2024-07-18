plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.widmeyertemplate.features.root"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.koinCore)
    implementation(libs.koinAndroid)
}