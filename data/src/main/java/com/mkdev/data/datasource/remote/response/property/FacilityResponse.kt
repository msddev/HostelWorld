package com.mkdev.data.datasource.remote.response.property


import com.google.gson.annotations.SerializedName

data class FacilityResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)