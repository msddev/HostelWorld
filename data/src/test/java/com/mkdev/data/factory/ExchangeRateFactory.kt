package com.mkdev.data.factory

import com.mkdev.data.datasource.remote.response.exchangeRates.ExchangeRatesResponse

internal fun createMockExchangeRatesResponse() = ExchangeRatesResponse(
    base = "USD",
    date = "2023-11-20",
    historical = false,
    rates = mapOf(
        "USD" to 1.0,
        "EUR" to 0.85,
        "GBP" to 0.75,
        "JPY" to 110.0,
        "AUD" to 1.35,
    ),
    success = true,
    timestamp = 1679328000
)

internal fun createMockEmptyExchangeRatesResponse() = ExchangeRatesResponse(
    base = "USD",
    date = "2023-11-20",
    historical = false,
    rates = emptyMap(),
    success = true,
    timestamp = 1679328000
)
