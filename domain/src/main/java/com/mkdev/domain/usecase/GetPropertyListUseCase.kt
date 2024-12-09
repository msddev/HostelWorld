package com.mkdev.domain.usecase

import com.mkdev.domain.entity.property.PropertyEntity
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyRepository
import com.mkdev.domain.utils.NetworkStatsActionKeys
import com.mkdev.domain.utils.trackNetworkStats
import io.reactivex.Single

class GetPropertyListUseCase(
    private val propertyRepository: PropertyRepository,
    private val networkStatsRepository: NetworkStatsRepository,
) {
    operator fun invoke(): Single<List<PropertyEntity>> {
        return propertyRepository.getProperties()
            .trackNetworkStats(
                repository = networkStatsRepository,
                action = NetworkStatsActionKeys.LOAD_PROPERTIES
            )
    }
}