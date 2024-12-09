package com.mkdev.data.datasource.mapper

import com.mkdev.data.datasource.remote.response.exchangeRates.ExchangeRatesResponse
import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity

internal fun ExchangeRatesResponse.toExchangeRatesEntity(): ExchangeRatesEntity {
    return ExchangeRatesEntity(
        rates = this.rates
    )
}