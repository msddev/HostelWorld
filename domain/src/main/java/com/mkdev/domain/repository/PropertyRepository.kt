package com.mkdev.domain.repository

import com.mkdev.domain.entity.PropertyEntity
import com.mkdev.domain.unit.Resource
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    fun getProperties(): Flow<Resource<List<PropertyEntity>>>
}