package com.mkdev.presentation.model

internal data class PropertyModel(
    val address1: String,
    val address2: String,
    val distance: DistanceModel,
    val facilities: List<FacilityListModel>,
    val freeCancellationAvailable: Boolean,
    val id: Int,
    val imagesGallery: List<ImagesGalleryModel>,
    val isFeatured: Boolean,
    val isNew: Boolean,
    val latitude: Double,
    val longitude: Double,
    val lowestDormPricePerNight: PricePerNightModel,
    val lowestPricePerNight: PricePerNightModel,
    val lowestPrivatePricePerNight: PricePerNightModel,
    val name: String,
    val overallRating: OverallRatingModel,
    val overview: String,
    val type: String,
)