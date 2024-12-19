package com.mkdev.domain.repository

import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel
import io.reactivex.Single

interface PropertyDetailRepository {
    fun getExchangeRates(): Single<ExchangeRatesModel>
}