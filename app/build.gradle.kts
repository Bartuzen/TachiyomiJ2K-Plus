plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinter)
}

android {
    namespace = "dev.bartuzen.xposed.tachiyomij2k"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.bartuzen.xposed.tachiyomij2k"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    compileOnly(libs.xposed)
}
