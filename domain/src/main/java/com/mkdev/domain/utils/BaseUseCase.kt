package com.mkdev.domain.utils

import com.mkdev.domain.repository.NetworkStatsRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 *
 * Implementation Sample:
 *
 * class GetExchangeRatesUseCase(
 *     private val propertyDetailRepository: PropertyDetailRepository,
 *     networkStatsRepository: NetworkStatsRepository,
 * ) : BaseUseCase<ExchangeRatesEntity>(networkStatsRepository) {
 *     operator fun invoke(): Single<ExchangeRatesEntity> {
 *         return trackNetworkStats(
 *             propertyDetailRepository.getExchangeRates(),
 *             NetworkStatsActionKeys.LOAD_RATES
 *         )
 *     }
 * }
 *
 */

abstract class BaseUseCase<T>(
    private val networkStatsRepository: NetworkStatsRepository
) {

    protected fun trackNetworkStats(
        single: Single<T>,
        action: String
    ): Single<T> {
        val startTime = System.currentTimeMillis()
        return single.doOnSuccess {
            val duration = System.currentTimeMillis() - startTime
            networkStatsRepository.trackNetworkStats(action, duration)
                .subscribeOn(Schedulers.io())
                .subscribe()
        }
    }
}