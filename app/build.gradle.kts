plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.androidscaffolding"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidscaffolding"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    // 뷰 바인딩을 사용한다고 설정
    buildFeatures {
        viewBinding = true
        dataBinding = true
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
    val nav_version = "2.5.3"
    val lifecycle_version = "2.6.2"
    val activity_version = "1.6.1"


    // 파이어베이스 인증, 제공된 UI 이용해보기. 패스
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0")


    // multiDex 임포트
    implementation ("androidx.multidex:multidex:2.0.1")

    // Firebase Auth
    implementation("com.google.firebase:firebase-auth-ktx")
    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))

    // When using the BoM, don't specify versions in Firebase dependencies
    implementation("com.google.firebase:firebase-analytics")

    //뷰모델 => 라이프 사이클 관련
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    //라이브 데이터 => 옵저버 패턴 참조
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")

    //retrofit 추가, gson 컨버터 추가.
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
// json 변환하기 위한 또라이브러리, gson 예시.
    implementation ("com.google.code.gson:gson:2.8.9")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


//    implementation 'com.google.code.gson:gson:2.8.9'
//    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//    implementation 'com.squareup.retrofit2:converter-gson:2.6.0'

    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.preference:preference-ktx:1.2.1")
}