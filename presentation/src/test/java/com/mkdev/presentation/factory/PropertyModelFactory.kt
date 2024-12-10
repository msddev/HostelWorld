package com.mkdev.presentation.factory

import com.mkdev.presentation.model.property.DistanceModel
import com.mkdev.presentation.model.property.FacilityListModel
import com.mkdev.presentation.model.property.FacilityModel
import com.mkdev.presentation.model.property.ImagesGalleryModel
import com.mkdev.presentation.model.property.OverallRatingModel
import com.mkdev.presentation.model.property.PricePerNightModel
import com.mkdev.presentation.model.property.PropertyModel

internal fun createMockPropertyModel(): PropertyModel {
    return PropertyModel(
        address1 = "123 Main St",
        address2 = "Apt 4B",
        distance = createMockDistanceModel(),
        facilities = listOf(createMockFacilityListModel()),
        freeCancellationAvailable = true,
        id = 1,
        imagesGallery = listOf(createMockImagesGalleryModel()),
        isFeatured = false,
        isNew = true,
        latitude = 37.7749,
        longitude = -122.4194,
        lowestPricePerNight = createMockPricePerNightModel(),
        name = "Property Name",
        overallRating = createMockOverallRatingModel(),
        overview = "Overview",
        type = "hotel"
    )
}

internal fun createMockDistanceModel(): DistanceModel {
    return DistanceModel(
        units = "km",
        value = 1.0
    )
}

internal fun createMockFacilityListModel(): FacilityListModel {
    return FacilityListModel(
        facilities = listOf(createMockFacilityModel()),
        name = "Facilities",
        id = "1"
    )
}

internal fun createMockFacilityModel(): FacilityModel {
    return FacilityModel(
        id = "1",
        name = "Facility Name"
    )
}

internal fun createMockImagesGalleryModel(): ImagesGalleryModel {
    return ImagesGalleryModel(
        prefix = "https://example.com/images/",
        suffix = ".jpg"
    )
}

internal fun createMockOverallRatingModel(): OverallRatingModel {
    return OverallRatingModel(
        numberOfRatings = "5",
        overall = 4
    )
}

internal fun createMockPricePerNightModel(): PricePerNightModel {
    return PricePerNightModel(
        currency = "USD",
        value = "100"
    )
}