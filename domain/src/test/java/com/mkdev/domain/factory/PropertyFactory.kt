package com.mkdev.domain.factory

import com.mkdev.domain.model.property.DistanceModel
import com.mkdev.domain.model.property.FacilityListModel
import com.mkdev.domain.model.property.FacilityModel
import com.mkdev.domain.model.property.ImagesGalleryModel
import com.mkdev.domain.model.property.OverallRatingModel
import com.mkdev.domain.model.property.PricePerNightModel
import com.mkdev.domain.model.property.PropertyModel

fun createMockOverallRatingModel() = OverallRatingModel(
    numberOfRatings = "100",
    overall = 4
)

internal fun createMockPricePerNightModel() = PricePerNightModel(
    currency = "USD",
    value = "100"
)

internal fun createMockImagesGalleryModel() = ImagesGalleryModel(
    prefix = "res.cloudinary.com/test-hostelworld-com/image/upload/f_auto,q_auto",
    suffix = "/v1/propertyimages/1/113/1.jpg"
)

internal fun createMockFacilityModel() = FacilityModel(
    id = "1",
    name = "Free WiFi"
)

internal fun createMockFacilityListModel() = FacilityListModel(
    facilities = listOf(createMockFacilityModel()),
    name = "General",
    id = "1"
)

internal fun createMockDistanceModel() = DistanceModel(
    units = "km",
    value = 2.5
)

internal fun createMockPropertyModel() = PropertyModel(
    address1 = "123 Main St",
    address2 = "Apt 4B",
    distance = createMockDistanceModel(),
    facilities = listOf(createMockFacilityListModel()),
    freeCancellationAvailable = true,
    id = 1,
    imagesGallery = listOf(
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
        createMockImagesGalleryModel(),
    ),
    isFeatured = true,
    isNew = false,
    latitude = 37.7749,
    longitude = -122.4194,
    lowestPricePerNight = createMockPricePerNightModel(),
    name = "Cozy Apartment",
    overallRating = createMockOverallRatingModel(),
    overview = "A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city.",
    type = "Apartment"
)

internal fun createMockPropertyModelList() = listOf(
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
    createMockPropertyModel(),
)