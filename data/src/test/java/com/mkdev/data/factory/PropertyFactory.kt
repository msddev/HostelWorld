package com.mkdev.data.factory

import com.mkdev.data.datasource.remote.response.property.DistanceResponse
import com.mkdev.data.datasource.remote.response.property.FacilityListResponse
import com.mkdev.data.datasource.remote.response.property.FacilityResponse
import com.mkdev.data.datasource.remote.response.property.ImagesGalleryResponse
import com.mkdev.data.datasource.remote.response.property.OverallRatingResponse
import com.mkdev.data.datasource.remote.response.property.PricePerNightResponse
import com.mkdev.data.datasource.remote.response.property.PropertyListResponse
import com.mkdev.data.datasource.remote.response.property.PropertyResponse

internal fun createMockPropertyListResponse(): PropertyListResponse {
    return PropertyListResponse(
        properties = listOf(createMockPropertyResponse(), createMockPropertyResponse())
    )
}

internal fun createMockPropertyResponse(): PropertyResponse {
    return PropertyResponse(
        address1 = "123 Main St",
        address2 = "Apt 4B",
        distance = createMockDistanceResponse(),
        facilities = listOf(createMockFacilityListResponse()),
        freeCancellationAvailable = true,
        id = 1,
        imagesGallery = listOf(createMockImagesGalleryResponse()),
        isFeatured = false,
        isNew = true,
        latitude = 37.7749,
        longitude = -122.4194,
        lowestPricePerNight = createMockPricePerNightResponse(),
        name = "Property Name",
        overallRating = createMockOverallRatingResponse(),
        overview = "Overview",
        type = "hotel"
    )
}

internal fun createMockDistanceResponse(): DistanceResponse {
    return DistanceResponse(
        units = "km",
        value = 1.0
    )
}

internal fun createMockFacilityListResponse(): FacilityListResponse {
    return FacilityListResponse(
        facilities = listOf(createMockFacilityResponse()),
        name = "Facilities",
        id = "1"
    )
}

internal fun createMockFacilityResponse(): FacilityResponse {
    return FacilityResponse(
        id = "1",
        name = "Facility Name"
    )
}

internal fun createMockImagesGalleryResponse(): ImagesGalleryResponse {
    return ImagesGalleryResponse(
        prefix = "https://example.com/images/",
        suffix = ".jpg"
    )
}

internal fun createMockOverallRatingResponse(): OverallRatingResponse {
    return OverallRatingResponse(
        numberOfRatings = "5",
        overall = 4
    )
}

internal fun createMockPricePerNightResponse(): PricePerNightResponse {
    return PricePerNightResponse(
        currency = "USD",
        value = "100"
    )
}