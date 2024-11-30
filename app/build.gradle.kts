plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "dam.pmdm.wikimario"
    compileSdk = 34

    defaultConfig {
        applicationId = "dam.pmdm.wikimario"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding=true
        dataBinding=true
    }
}

dependencies {
    implementation(libs.recyclerview)
    implementation(libs.cardview)
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)
    implementation(libs.core.splashscreen)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}