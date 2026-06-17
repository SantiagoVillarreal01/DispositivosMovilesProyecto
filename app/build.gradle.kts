plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.navigation.safeargs)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.dispmovilesproyecto"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.dispmovilesproyecto"
        minSdk = 29
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        viewBinding = true
    }
}

// Configura las opciones del compilador de Kotlin a nivel raíz (fuera de 'android')
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.picasso)

    // Integración de Views/Fragments
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    implementation(platform("com.google.firebase:firebase-bom:34.14.0"))
    implementation("com.firebaseui:firebase-ui-auth:9.0.0")
    implementation("com.google.firebase:firebase-firestore")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.10.0")
    implementation("androidx.fragment:fragment-ktx:1.8.9") // Needed for easy initialization

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.10.0")

}