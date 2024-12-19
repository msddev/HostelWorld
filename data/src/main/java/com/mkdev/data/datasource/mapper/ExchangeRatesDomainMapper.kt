package com.mkdev.data.datasource.mapper

import com.mkdev.data.datasource.remote.response.exchangeRates.ExchangeRatesResponse
import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel
import javax.inject.Inject

class ExchangeRatesDomainMapper @Inject constructor() {

    fun mapToExchangeRatesModel(exchangeRatesResponse: ExchangeRatesResponse): ExchangeRatesModel {
        return ExchangeRatesModel(
            rates = exchangeRatesResponse.rates
        )
    }
}