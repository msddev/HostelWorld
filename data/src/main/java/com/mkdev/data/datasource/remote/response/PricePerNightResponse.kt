package com.mkdev.data.datasource.remote.response


import com.google.gson.annotations.SerializedName

data class PricePerNightResponse(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("value")
    val value: String
)