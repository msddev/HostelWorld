package com.mkdev.domain.repository

import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity
import io.reactivex.Single

interface PropertyDetailRepository {
    fun getExchangeRates(): Single<ExchangeRatesEntity>
}