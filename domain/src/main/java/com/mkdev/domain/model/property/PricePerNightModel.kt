package com.mkdev.domain.model.property


data class PricePerNightModel(
    val currency: String,
    val value: String,
){
    fun getCurrencySymbol(): String {
        return when (currency) {
            "USD" -> "$"
            "GBP" -> "£"
            else -> "€"
        }
    }
}