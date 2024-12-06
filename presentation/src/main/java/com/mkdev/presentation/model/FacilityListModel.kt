package com.mkdev.presentation.model

internal data class FacilityListModel(
    val facilities: List<FacilityModel>,
    val name: String,
    val id: String,
)