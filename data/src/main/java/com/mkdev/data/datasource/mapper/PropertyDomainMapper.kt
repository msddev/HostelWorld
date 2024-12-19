package com.mkdev.data.datasource.mapper

import com.mkdev.data.datasource.remote.response.property.DistanceResponse
import com.mkdev.data.datasource.remote.response.property.FacilityListResponse
import com.mkdev.data.datasource.remote.response.property.FacilityResponse
import com.mkdev.data.datasource.remote.response.property.ImagesGalleryResponse
import com.mkdev.data.datasource.remote.response.property.OverallRatingResponse
import com.mkdev.data.datasource.remote.response.property.PricePerNightResponse
import com.mkdev.data.datasource.remote.response.property.PropertyListResponse
import com.mkdev.data.datasource.remote.response.property.PropertyResponse
import com.mkdev.domain.model.property.DistanceModel
import com.mkdev.domain.model.property.FacilityListModel
import com.mkdev.domain.model.property.FacilityModel
import com.mkdev.domain.model.property.ImagesGalleryModel
import com.mkdev.domain.model.property.OverallRatingModel
import com.mkdev.domain.model.property.PricePerNightModel
import com.mkdev.domain.model.property.PropertyModel
import javax.inject.Inject

class PropertyDomainMapper @Inject constructor() {

    fun mapToPropertyListModel(propertyListResponse: PropertyListResponse): List<PropertyModel> {
        return propertyListResponse.properties.map {
            mapToPropertyModel(it)
        }
    }

    fun mapToPropertyModel(propertyResponse: PropertyResponse): PropertyModel {
        return PropertyModel(
            address1 = propertyResponse.address1,
            address2 = propertyResponse.address2,
            distance = mapToDistanceModel(propertyResponse.distance),
            facilities = propertyResponse.facilities.map { mapToFacilityListModel(it) },
            freeCancellationAvailable = propertyResponse.freeCancellationAvailable,
            id = propertyResponse.id,
            imagesGallery = propertyResponse.imagesGallery.map { mapToImagesGalleryModel(it) },
            isFeatured = propertyResponse.isFeatured,
            isNew = propertyResponse.isNew,
            latitude = propertyResponse.latitude,
            longitude = propertyResponse.longitude,
            lowestPricePerNight = mapToPricePerNightModel(propertyResponse.lowestPricePerNight),
            name = propertyResponse.name,
            overallRating = mapToOverallRatingModel(propertyResponse.overallRating),
            overview = propertyResponse.overview,
            type = propertyResponse.type
        )
    }

    fun mapToDistanceModel(distanceResponse: DistanceResponse): DistanceModel {
        return DistanceModel(
            units = distanceResponse.units,
            value = distanceResponse.value
        )
    }

    fun mapToFacilityListModel(facilityListResponse: FacilityListResponse): FacilityListModel {
        return FacilityListModel(
            facilities = facilityListResponse.facilities.map { mapToFacilityModel(it) },
            name = facilityListResponse.name,
            id = facilityListResponse.id
        )
    }

    fun mapToFacilityModel(facilityResponse: FacilityResponse): FacilityModel {
        return FacilityModel(
            id = facilityResponse.id,
            name = facilityResponse.name
        )
    }

    fun mapToImagesGalleryModel(imagesGalleryResponse: ImagesGalleryResponse): ImagesGalleryModel {
        return ImagesGalleryModel(
            prefix = imagesGalleryResponse.prefix,
            suffix = imagesGalleryResponse.suffix
        )
    }

    fun mapToOverallRatingModel(overallRatingResponse: OverallRatingResponse): OverallRatingModel {
        return OverallRatingModel(
            numberOfRatings = overallRatingResponse.numberOfRatings,
            overall = overallRatingResponse.overall
        )
    }

    fun mapToPricePerNightModel(pricePerNightResponse: PricePerNightResponse): PricePerNightModel {
        return PricePerNightModel(
            currency = pricePerNightResponse.currency,
            value = pricePerNightResponse.value
        )
    }
}