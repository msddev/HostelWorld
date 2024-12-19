package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.PropertyDomainMapper
import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.domain.model.property.PropertyModel
import com.mkdev.domain.repository.PropertyRepository
import io.reactivex.Single

class PropertyRepositoryImpl(
    private val propertyApi: PropertyApi,
    private val propertyDomainMapper: PropertyDomainMapper,
) : PropertyRepository {

    override fun getProperties(): Single<List<PropertyModel>> {
        return propertyApi.getProperties()
            .map { propertyListResponse ->
                propertyDomainMapper.mapToPropertyListModel(propertyListResponse)
            }
    }
}