plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.ecofarm" // Defina o namespace aqui, que corresponde ao 'package' no AndroidManifest.xml
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ecofarm"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    kotlinOptions {
        jvmTarget = "17" // Ajuste o jvmTarget para compatibilidade com o Kotlin
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // Definir a versão do Java para 17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.compose.ui:ui:1.6.1")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.1")
    implementation(libs.androidx.foundation.android)
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.1")

    // Adicionando dependências de navegação
    implementation("androidx.navigation:navigation-compose:2.5.3")
}
