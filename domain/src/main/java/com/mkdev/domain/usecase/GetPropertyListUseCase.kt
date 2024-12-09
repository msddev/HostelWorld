package com.mkdev.domain.usecase

import com.mkdev.domain.entity.property.PropertyEntity
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyRepository
import com.mkdev.domain.utils.NetworkStatsActionKeys
import io.reactivex.Single

class GetPropertyListUseCase(
    private val propertyRepository: PropertyRepository,
    private val networkStatsRepository: NetworkStatsRepository,
) {
    operator fun invoke(): Single<List<PropertyEntity>> {
        val startTime = System.currentTimeMillis()

        return propertyRepository.getProperties()
            .doOnSuccess {
                val duration = System.currentTimeMillis() - startTime
                networkStatsRepository.trackNetworkStats(
                    action = NetworkStatsActionKeys.LOAD_LIST,
                    duration = duration
                ).subscribe() // Subscribe to trigger the tracking
            }
    }
}