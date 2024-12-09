package com.mkdev.domain.usecase

import com.mkdev.domain.entity.property.PropertyEntity
import com.mkdev.domain.repository.PropertyRepository
import io.reactivex.Single

class GetPropertyListUseCase(
    private val propertyRepository: PropertyRepository,
) {
    operator fun invoke(): Single<List<PropertyEntity>> {
        return propertyRepository.getProperties()
    }
}