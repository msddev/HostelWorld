package com.mkdev.data.datasource.remote.response

import com.google.gson.annotations.SerializedName

data class PropertyResponse(
    @SerializedName("address1")
    val address1: String,
    @SerializedName("address2")
    val address2: String,
    @SerializedName("distance")
    val distance: DistanceResponse,
    @SerializedName("facilities")
    val facilities: List<FacilityListResponse>,
    @SerializedName("freeCancellationAvailable")
    val freeCancellationAvailable: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("imagesGallery")
    val imagesGallery: List<ImagesGalleryResponse>,
    @SerializedName("isFeatured")
    val isFeatured: Boolean,
    @SerializedName("isNew")
    val isNew: Boolean,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("lowestPricePerNight")
    val lowestPricePerNight: PricePerNightResponse,
    @SerializedName("name")
    val name: String,
    @SerializedName("overallRating")
    val overallRating: OverallRatingResponse,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("type")
    val type: String,
)