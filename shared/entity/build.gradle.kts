plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinSerialization)
            //put your multiplatform dependencies here
        }
    }
}

dependencies {
//    commonMainImplementation(projects.mppLibrary.resources)
//    commonMainApi(libs.kotlinxDateTime)
//    commonMainApi(libs.napier)
//    commonMainApi(libs.kotlinSerialization)
//    commonMainApi(libs.mokoNetwork)
//    commonMainApi(libs.ktorClient)
}

android {
    namespace = "com.widmeyertemplate.entity"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
