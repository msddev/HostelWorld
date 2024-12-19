package com.mkdev.presentation.mapper

import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel

internal fun ExchangeRatesModel.toExchangeRatesModel(): ExchangeRatesModel {
    return ExchangeRatesModel(
        rates = this.rates
    )
}



