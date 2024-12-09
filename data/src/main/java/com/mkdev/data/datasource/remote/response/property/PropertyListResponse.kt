package com.mkdev.data.datasource.remote.response.property


import com.google.gson.annotations.SerializedName

data class PropertyListResponse(
    @SerializedName("properties")
    val properties: List<PropertyResponse>,
)