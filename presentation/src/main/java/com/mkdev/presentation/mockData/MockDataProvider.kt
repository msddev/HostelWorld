package com.mkdev.presentation.mockData

import com.mkdev.presentation.model.property.DistanceModel
import com.mkdev.presentation.model.property.FacilityListModel
import com.mkdev.presentation.model.property.FacilityModel
import com.mkdev.presentation.model.property.ImagesGalleryModel
import com.mkdev.presentation.model.property.OverallRatingModel
import com.mkdev.presentation.model.property.PricePerNightModel
import com.mkdev.presentation.model.property.PropertyModel


internal fun mockOverallRatingModel() = OverallRatingModel(
    numberOfRatings = "100",
    overall = 4
)

internal fun mockPricePerNightModel() = PricePerNightModel(
    currency = "USD",
    value = "100"
)

internal fun mockImagesGalleryModel() = ImagesGalleryModel(
    prefix = "res.cloudinary.com/test-hostelworld-com/image/upload/f_auto,q_auto",
    suffix = "/v1/propertyimages/1/113/1.jpg"
)

internal fun mockFacilityModel() = FacilityModel(
    id = "1",
    name = "Free WiFi"
)

internal fun mockFacilityListModel() = FacilityListModel(
    facilities = listOf(mockFacilityModel()),
    name = "General",
    id = "1"
)

internal fun mockDistanceModel() = DistanceModel(
    units = "km",
    value = 2.5
)

internal fun mockPropertyModel() = PropertyModel(
    address1 = "123 Main St",
    address2 = "Apt 4B",
    distance = mockDistanceModel(),
    facilities = listOf(mockFacilityListModel()),
    freeCancellationAvailable = true,
    id = 1,
    imagesGallery = listOf(
        mockImagesGalleryModel(),
        mockImagesGalleryModel(),
        mockImagesGalleryModel(),
        mockImagesGalleryModel(),
        mockImagesGalleryModel(),
    ),
    isFeatured = true,
    isNew = false,
    latitude = 37.7749,
    longitude = -122.4194,
    lowestPricePerNight = mockPricePerNightModel(),
    name = "Cozy Apartment",
    overallRating = mockOverallRatingModel(),
    overview = "A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city. A comfortable and modern apartment in the heart of the city.",
    type = "Apartment"
)

internal val mockPropertyList = listOf(
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel()
)

internal val mockPropertyItem = mockPropertyModel()