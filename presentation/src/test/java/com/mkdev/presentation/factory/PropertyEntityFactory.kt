package com.mkdev.presentation.factory

import com.mkdev.domain.model.property.DistanceModel
import com.mkdev.domain.model.property.FacilityModel
import com.mkdev.domain.model.property.FacilityListModel
import com.mkdev.domain.model.property.ImagesGalleryModel
import com.mkdev.domain.model.property.OverallRatingModel
import com.mkdev.domain.model.property.PricePerNightModel
import com.mkdev.domain.model.property.PropertyModel

fun createMockOverallRatingEntity() = OverallRatingModel(
    numberOfRatings = "100",
    overall = 4
)

internal fun createMockPricePerNightEntity() = PricePerNightModel(
    currency = "USD",
    value = "100"
)

internal fun createMockImagesGalleryEntity() = ImagesGalleryModel(
    prefix = "res.cloudinary.com/test-hostelworld-com/image/upload/f_auto,q_auto",
    suffix = "/v1/propertyimages/1/113/1.jpg"
)

internal fun createMockFacilityEntity() = FacilityModel(
    id = "1",
    name = "Free WiFi"
)

internal fun createMockFacilityListEntity() = FacilityListModel(
    facilities = listOf(createMockFacilityEntity()),
    name = "General",
    id = "1"
)

internal fun createMockDistanceEntity() = DistanceModel(
    units = "km",
    value = 2.5
)

internal fun createMockPropertyEntity() = PropertyModel(
    address1 = "123 Main St",
    address2 = "Apt 4B",
    distance = createMockDistanceEntity(),
    facilities = listOf(createMockFacilityListEntity()),
    freeCancellationAvailable = true,
    id = 1,
    imagesGallery = listOf(
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
        createMockImagesGalleryEntity(),
    ),
    isFeatured = true,
    isNew = false,
    latitude = 37.7749,
    longitude = -122.4194,
    lowestPricePerNight = createMockPricePerNightEntity(),
    name = "Cozy Apartment",
    overallRating = createMockOverallRatingEntity(),
    overview = "A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city.",
    type = "Apartment"
)

internal fun createMockPropertyEntityList() = listOf(
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
    createMockPropertyEntity(),
)