package com.mkdev.domain.repository

import com.mkdev.domain.entity.property.PropertyEntity
import io.reactivex.Single

interface PropertyRepository {
    fun getProperties(): Single<List<PropertyEntity>>
}