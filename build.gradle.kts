// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    id(libs.plugins.dagger.hilt.get().toString()) version libs.versions.hilt apply false
    id(libs.plugins.ksp.get().toString()) version libs.versions.ksp apply false
}