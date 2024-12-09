package com.mkdev.domain.usecase

import com.mkdev.domain.entity.exchangeRates.ExchangeRatesEntity
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyDetailRepository
import com.mkdev.domain.utils.NetworkStatsActionKeys
import io.reactivex.Single

class GetExchangeRatesUseCase(
    private val propertyDetailRepository: PropertyDetailRepository,
    private val networkStatsRepository: NetworkStatsRepository,
) {
    operator fun invoke(): Single<ExchangeRatesEntity> {
        val startTime = System.currentTimeMillis()
        return propertyDetailRepository.getExchangeRates()
            .doOnSuccess {
                val duration = System.currentTimeMillis() - startTime
                networkStatsRepository.trackNetworkStats(
                    action = NetworkStatsActionKeys.LOAD_RATES,
                    duration = duration
                ).subscribe()
            }
    }
}