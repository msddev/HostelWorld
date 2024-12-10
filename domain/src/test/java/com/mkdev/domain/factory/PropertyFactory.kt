package com.mkdev.domain.factory

import com.mkdev.domain.entity.property.DistanceEntity
import com.mkdev.domain.entity.property.FacilityEntity
import com.mkdev.domain.entity.property.FacilityListEntity
import com.mkdev.domain.entity.property.ImagesGalleryEntity
import com.mkdev.domain.entity.property.OverallRatingEntity
import com.mkdev.domain.entity.property.PricePerNightEntity
import com.mkdev.domain.entity.property.PropertyEntity

internal fun createMockOverallRatingEntity() = OverallRatingEntity(
    numberOfRatings = "100",
    overall = 4
)

internal fun createMockPricePerNightEntity() = PricePerNightEntity(
    currency = "USD",
    value = "100"
)

internal fun createMockImagesGalleryEntity() = ImagesGalleryEntity(
    prefix = "res.cloudinary.com/test-hostelworld-com/image/upload/f_auto,q_auto",
    suffix = "/v1/propertyimages/1/113/1.jpg"
)

internal fun createMockFacilityEntity() = FacilityEntity(
    id = "1",
    name = "Free WiFi"
)

internal fun createMockFacilityListEntity() = FacilityListEntity(
    facilities = listOf(createMockFacilityEntity()),
    name = "General",
    id = "1"
)

internal fun createMockDistanceEntity() = DistanceEntity(
    units = "km",
    value = 2.5
)

internal fun createMockPropertyEntity() = PropertyEntity(
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