import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
}

repositories {
    mavenCentral()
    google()
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        val desktopMain by getting
        
        androidMain.dependencies {
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
            implementation("androidx.compose.material3:material3:1.1.2")
            implementation("androidx.compose.material3:material3-window-size-class:1.1.2")
            implementation("androidx.compose.material:material-icons-core:1.3.1")
            implementation("androidx.compose.material:material-icons-extended:1.3.1")
            implementation("io.insert-koin:koin-android:3.2.0")

        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.ktor.client.core)
            implementation("io.ktor:ktor-client-cio:2.3.6")
            implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
            implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
            implementation("io.ktor:ktor-client-core:2.3.6")
            implementation("io.ktor:ktor-client-json:1.6.4")
            implementation("io.ktor:ktor-client-serialization:2.3.6")

            implementation("io.ktor:ktor-client-logging:2.3.6")
            implementation("io.insert-koin:koin-core:3.4.0")
            implementation("io.insert-koin:koin-ktor:3.4.0")
            implementation("io.insert-koin:koin-logger-slf4j:3.4.0")
            implementation("io.insert-koin:koin-android:3.4.0")
            implementation ("io.insert-koin:koin-androidx-compose:3.4.0")


        }
        //for iOS {implementation(libs.ktor.client.darwin)}
    }
}

android {
    namespace = "org.example.project"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "org.example.project"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
        //kotlinCompilerExtensionVersion = "1.1.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/INDEX.LIST"
            excludes += "/META-INF/io.netty.versions.properties"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
dependencies {
    implementation(libs.androidx.material)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.project"
            packageVersion = "1.0.0"
        }
    }
}
