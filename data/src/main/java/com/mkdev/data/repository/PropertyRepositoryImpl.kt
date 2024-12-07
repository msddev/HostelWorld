package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.toPropertyEntities
import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.domain.entity.PropertyEntity
import com.mkdev.domain.repository.PropertyRepository
import io.reactivex.Single

class PropertyRepositoryImpl(
    private val propertyApi: PropertyApi,
) : PropertyRepository {

    override fun getProperties(): Single<List<PropertyEntity>> {
        return propertyApi.getProperties()
            .map { propertyListResponse ->
                propertyListResponse.toPropertyEntities()
            }
    }
}