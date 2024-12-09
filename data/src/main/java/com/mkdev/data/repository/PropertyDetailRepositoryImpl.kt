package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.toExchangeRatesEntity
import com.mkdev.data.datasource.remote.api.ExchangeRatesApi
import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity
import com.mkdev.domain.repository.PropertyDetailRepository
import io.reactivex.Single

class PropertyDetailRepositoryImpl(
    private val exchangeRatesApi: ExchangeRatesApi,
) : PropertyDetailRepository {

    override fun getExchangeRates(): Single<ExchangeRatesEntity> {
        return exchangeRatesApi.getExchangeRates().map { exchangeRatesResponse ->
            exchangeRatesResponse.toExchangeRatesEntity()
        }
    }
}