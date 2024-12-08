package com.mkdev.presentation.mockData

import com.mkdev.presentation.model.DistanceModel
import com.mkdev.presentation.model.FacilityListModel
import com.mkdev.presentation.model.FacilityModel
import com.mkdev.presentation.model.ImagesGalleryModel
import com.mkdev.presentation.model.OverallRatingModel
import com.mkdev.presentation.model.PricePerNightModel
import com.mkdev.presentation.model.PropertyModel


internal fun mockOverallRatingModel() = OverallRatingModel(
    numberOfRatings = "100",
    overall = 4
)

internal fun mockPricePerNightModel() = PricePerNightModel(
    currency = "USD",
    value = "100"
)

internal fun mockImagesGalleryModel() = ImagesGalleryModel(
    prefix = "https://example.com/images/",
    suffix = "property_1.jpg"
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
    imagesGallery = listOf(mockImagesGalleryModel()),
    isFeatured = true,
    isNew = false,
    latitude = 37.7749,
    longitude = -122.4194,
    lowestPricePerNight = mockPricePerNightModel(),
    name = "Cozy Apartment",
    overallRating = mockOverallRatingModel(),
    overview = "A comfortable and modern apartment in the heart of the city.",
    type = "Apartment"
)

internal val mockPropertyList = listOf(
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel(),
    mockPropertyModel()
)