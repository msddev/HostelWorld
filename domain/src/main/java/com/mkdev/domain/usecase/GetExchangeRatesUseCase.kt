package com.mkdev.domain.usecase

import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity
import com.mkdev.domain.repository.PropertyDetailRepository
import io.reactivex.Single

class GetExchangeRatesUseCase(
    private val propertyDetailRepository: PropertyDetailRepository,
) {
    operator fun invoke(): Single<ExchangeRatesEntity> {
        return propertyDetailRepository.getExchangeRates()
    }
}