package com.mkdev.domain.entity

data class FacilityListEntity(
    val facilities: List<FacilityEntity>,
    val name: String,
    val id: String,
)