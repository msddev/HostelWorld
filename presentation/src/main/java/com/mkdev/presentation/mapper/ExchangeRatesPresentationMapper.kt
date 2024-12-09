package com.mkdev.presentation.mapper

import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity
import com.mkdev.presentation.model.exchangeRates.ExchangeRatesModel

internal fun ExchangeRatesEntity.toExchangeRatesModel(): ExchangeRatesModel {
    return ExchangeRatesModel(
        rates = this.rates
    )
}



