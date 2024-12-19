package com.mkdev.domain.repository

import com.mkdev.domain.model.property.PropertyModel
import io.reactivex.Single

interface PropertyRepository {
    fun getProperties(): Single<List<PropertyModel>>
}