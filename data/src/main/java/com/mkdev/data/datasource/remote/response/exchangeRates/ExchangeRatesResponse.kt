package com.mkdev.data.datasource.remote.response.exchangeRates


import com.google.gson.annotations.SerializedName

data class ExchangeRatesResponse(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("historical")
    val historical: Boolean,
    @SerializedName("rates")
    val rates: Map<String, Double>,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("timestamp")
    val timestamp: Int
)