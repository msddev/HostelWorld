package com.mkdev.domain.entity


data class PropertyEntity(
    val address1: String,
    val address2: String,
    val distance: DistanceEntity,
    val facilities: List<FacilityListEntity>,
    val freeCancellationAvailable: Boolean,
    val id: Int,
    val imagesGallery: List<ImagesGalleryEntity>,
    val isFeatured: Boolean,
    val isNew: Boolean,
    val latitude: Double,
    val longitude: Double,
    val lowestPricePerNight: PricePerNightEntity,
    val name: String,
    val overallRating: OverallRatingEntity,
    val overview: String,
    val type: String,
)