package com.mkdev.data.datasource.remote.response


import com.google.gson.annotations.SerializedName

data class DistanceResponse(
    @SerializedName("units")
    val units: String,
    @SerializedName("value")
    val value: Double
)