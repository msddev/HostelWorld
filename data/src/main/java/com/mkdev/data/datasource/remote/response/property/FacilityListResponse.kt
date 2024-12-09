package com.mkdev.data.datasource.remote.response.property


import com.google.gson.annotations.SerializedName

data class FacilityListResponse(
    @SerializedName("facilities")
    val facilities: List<FacilityResponse>,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: String,
)