package com.mkdev.domain.usecase

import com.mkdev.domain.entity.PropertyEntity
import com.mkdev.domain.repository.PropertyRepository
import com.mkdev.domain.unit.Resource
import kotlinx.coroutines.flow.Flow

class GetPropertyListUseCase(
    private val propertyRepository: PropertyRepository,
) {
    operator fun invoke(): Flow<Resource<List<PropertyEntity>>> {
        return propertyRepository.getProperties()
    }
}