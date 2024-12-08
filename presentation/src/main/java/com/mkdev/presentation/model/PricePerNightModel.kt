package com.mkdev.presentation.model

internal data class PricePerNightModel(
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