package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.ExchangeRatesDomainMapper
import com.mkdev.data.datasource.remote.api.ExchangeRatesApi
import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel
import com.mkdev.domain.repository.PropertyDetailRepository
import io.reactivex.Single

class PropertyDetailRepositoryImpl(
    private val exchangeRatesApi: ExchangeRatesApi,
    private val exchangeRatesDomainMapper: ExchangeRatesDomainMapper
) : PropertyDetailRepository {

    override fun getExchangeRates(): Single<ExchangeRatesModel> {
        return exchangeRatesApi.getExchangeRates().map { exchangeRatesResponse ->
            exchangeRatesDomainMapper.mapToExchangeRatesModel(exchangeRatesResponse)
        }
    }
}