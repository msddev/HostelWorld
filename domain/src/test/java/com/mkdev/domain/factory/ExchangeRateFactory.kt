package com.mkdev.domain.factory

import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel


internal fun createMockExchangeRatesEntity() = ExchangeRatesModel(
    rates = mapOf(
        "EUR" to 0.85,
        "USD" to 1.0,
        "GBP" to 0.75,
        "JPY" to 110.0,
        "AUD" to 1.35,
        "CAD" to 1.25,
        "CHF" to 0.95,
        "CNY" to 6.5,
        "HKD" to 7.8,
        "INR" to 75.0,
    )
)
