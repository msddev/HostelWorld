package com.mkdev.data.repository

import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.domain.entity.PropertyEntity
import com.mkdev.domain.repository.PropertyRepository
import com.mkdev.domain.unit.Resource
import kotlinx.coroutines.flow.Flow

internal class PropertyRepositoryImpl(
    private val propertyApi: PropertyApi,
) : PropertyRepository {

    override fun getProperties(): Flow<Resource<List<PropertyEntity>>> {
        TODO("Not yet implemented")
    }
}