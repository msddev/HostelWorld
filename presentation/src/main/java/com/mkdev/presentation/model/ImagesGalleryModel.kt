package com.mkdev.presentation.model

internal data class ImagesGalleryModel(
    val prefix: String,
    val suffix: String,
) {
    fun getImageUrl(): String {
        return prefix + suffix
    }
}