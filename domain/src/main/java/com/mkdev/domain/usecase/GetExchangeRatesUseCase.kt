package com.mkdev.domain.usecase

import com.mkdev.domain.model.exchangeRates.ExchangeRatesModel
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyDetailRepository
import com.mkdev.domain.utils.NetworkStatsActionKeys
import com.mkdev.domain.utils.trackNetworkStats
import io.reactivex.Single

class GetExchangeRatesUseCase(
    private val propertyDetailRepository: PropertyDetailRepository,
    private val networkStatsRepository: NetworkStatsRepository,
) {
    operator fun invoke(): Single<ExchangeRatesModel> {
        return propertyDetailRepository.getExchangeRates()
            .trackNetworkStats(
                repository = networkStatsRepository,
                action = NetworkStatsActionKeys.LOAD_RATES
            )
    }
}