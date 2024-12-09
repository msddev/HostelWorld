package com.mkdev.data.datasource.remote.response.property


import com.google.gson.annotations.SerializedName

data class ImagesGalleryResponse(
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String
)