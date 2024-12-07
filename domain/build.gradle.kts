plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {

    // Rx
    implementation(libs.rxjava2)
    implementation(libs.rxkotlin2)
}
