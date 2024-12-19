package com.mkdev.domain.model.property

data class FacilityListModel(
    val facilities: List<FacilityModel>,
    val name: String,
    val id: String,
)