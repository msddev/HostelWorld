package com.mkdev.domain.entity.property

data class FacilityListEntity(
    val facilities: List<FacilityEntity>,
    val name: String,
    val id: String,
)