package com.mkdev.presentation.model.property

internal data class FacilityListModel(
    val facilities: List<FacilityModel>,
    val name: String,
    val id: String,
)