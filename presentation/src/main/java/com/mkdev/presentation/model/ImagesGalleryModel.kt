package com.mkdev.presentation.model

internal data class ImagesGalleryModel(
    val prefix: String,
    val suffix: String,
) {
    fun getImageUrl(): String {
        val url = prefix + suffix
        return if (url.startsWith("http://") || url.startsWith("https://")) {
            url
        } else {
            "https://$url"
        }
    }
}