package com.mkdev.data.datasource.mapper

import com.mkdev.data.datasource.remote.response.DistanceResponse
import com.mkdev.data.datasource.remote.response.FacilityListResponse
import com.mkdev.data.datasource.remote.response.FacilityResponse
import com.mkdev.data.datasource.remote.response.ImagesGalleryResponse
import com.mkdev.data.datasource.remote.response.OverallRatingResponse
import com.mkdev.data.datasource.remote.response.PricePerNightResponse
import com.mkdev.data.datasource.remote.response.PropertyListResponse
import com.mkdev.data.datasource.remote.response.PropertyResponse
import com.mkdev.domain.entity.DistanceEntity
import com.mkdev.domain.entity.FacilityEntity
import com.mkdev.domain.entity.FacilityListEntity
import com.mkdev.domain.entity.ImagesGalleryEntity
import com.mkdev.domain.entity.OverallRatingEntity
import com.mkdev.domain.entity.PricePerNightEntity
import com.mkdev.domain.entity.PropertyEntity

internal fun PropertyListResponse.toPropertyEntities(): List<PropertyEntity> {
    return this.properties.map { it.toPropertyEntity() }
}

internal fun PropertyResponse.toPropertyEntity(): PropertyEntity {
    return PropertyEntity(
        address1 = this.address1,
        address2 = this.address2,
        distance = this.distance.toDistanceEntity(),
        facilities = this.facilities.map { it.toFacilityListEntity() },
        freeCancellationAvailable = this.freeCancellationAvailable,
        id = this.id,
        imagesGallery = this.imagesGallery.map { it.toImagesGalleryEntity() },
        isFeatured = this.isFeatured,
        isNew = this.isNew,
        latitude = this.latitude,
        longitude = this.longitude,
        lowestPricePerNight = this.lowestPricePerNight.toPricePerNightEntity(),
        name = this.name,
        overallRating = this.overallRating.toOverallRatingEntity(),
        overview = this.overview,
        type = this.type
    )
}

internal fun DistanceResponse.toDistanceEntity(): DistanceEntity {
    return DistanceEntity(
        units = this.units,
        value = this.value
    )
}

internal fun FacilityListResponse.toFacilityListEntity(): FacilityListEntity {
    return FacilityListEntity(
        facilities = this.facilities.map { it.toFacilityEntity() },
        name = this.name,
        id = this.id
    )
}

internal fun FacilityResponse.toFacilityEntity(): FacilityEntity {
    return FacilityEntity(
        id = this.id,
        name = this.name
    )
}

internal fun ImagesGalleryResponse.toImagesGalleryEntity(): ImagesGalleryEntity {
    return ImagesGalleryEntity(
        prefix = this.prefix,
        suffix = this.suffix
    )
}

internal fun OverallRatingResponse.toOverallRatingEntity(): OverallRatingEntity {
    return OverallRatingEntity(
        numberOfRatings = this.numberOfRatings,
        overall = this.overall
    )
}

internal fun PricePerNightResponse.toPricePerNightEntity(): PricePerNightEntity {
    return PricePerNightEntity(
        currency = this.currency,
        value = this.value
    )
}