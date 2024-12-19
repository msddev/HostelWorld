package com.mkdev.data.factory

import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel

internal fun createMockExchangeRatesModel() = ExchangeRatesModel(
    rates = mapOf(
        "USD" to 1.0,
        "EUR" to 0.85,
        "GBP" to 0.75,
        "JPY" to 110.0,
        "AUD" to 1.35,
    ),
)

internal fun createMockEmptyExchangeRatesModel() = ExchangeRatesModel(
    rates = emptyMap(),
)
