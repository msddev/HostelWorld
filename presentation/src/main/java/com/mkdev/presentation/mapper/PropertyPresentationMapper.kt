package com.mkdev.presentation.mapper

import com.mkdev.domain.entity.property.DistanceEntity
import com.mkdev.domain.entity.property.FacilityEntity
import com.mkdev.domain.entity.property.FacilityListEntity
import com.mkdev.domain.entity.property.ImagesGalleryEntity
import com.mkdev.domain.entity.property.OverallRatingEntity
import com.mkdev.domain.entity.property.PricePerNightEntity
import com.mkdev.domain.entity.property.PropertyEntity
import com.mkdev.presentation.model.property.DistanceModel
import com.mkdev.presentation.model.property.FacilityListModel
import com.mkdev.presentation.model.property.FacilityModel
import com.mkdev.presentation.model.property.ImagesGalleryModel
import com.mkdev.presentation.model.property.OverallRatingModel
import com.mkdev.presentation.model.property.PricePerNightModel
import com.mkdev.presentation.model.property.PropertyModel

internal fun PropertyEntity.toPropertyModel(): PropertyModel {
    return PropertyModel(
        address1 = this.address1,
        address2 = this.address2,
        distance = this.distance.toDistanceModel(),
        facilities = this.facilities.map { it.toFacilityListModel() },
        freeCancellationAvailable = this.freeCancellationAvailable,
        id = this.id,
        imagesGallery = this.imagesGallery.map { it.toImagesGalleryModel() },
        isFeatured = this.isFeatured,
        isNew = this.isNew,
        latitude = this.latitude,
        longitude = this.longitude,
        lowestPricePerNight = this.lowestPricePerNight.toPricePerNightModel(),
        name = this.name,
        overallRating = this.overallRating.toOverallRatingModel(),
        overview = this.overview,
        type = this.type
    )
}

internal fun DistanceEntity.toDistanceModel(): DistanceModel {
    return DistanceModel(
        units = this.units,
        value = this.value
    )
}

internal fun FacilityEntity.toFacilityModel(): FacilityModel {
    return FacilityModel(
        id = this.id,
        name = this.name
    )
}

internal fun FacilityListEntity.toFacilityListModel(): FacilityListModel {
    return FacilityListModel(
        facilities = this.facilities.map { it.toFacilityModel() },
        name = this.name,
        id = this.id
    )
}

internal fun ImagesGalleryEntity.toImagesGalleryModel(): ImagesGalleryModel {
    return ImagesGalleryModel(
        prefix = this.prefix,
        suffix = this.suffix
    )
}

internal fun OverallRatingEntity.toOverallRatingModel(): OverallRatingModel {
    return OverallRatingModel(
        numberOfRatings = this.numberOfRatings,
        overall = this.overall
    )
}

internal fun PricePerNightEntity.toPricePerNightModel(): PricePerNightModel {
    return PricePerNightModel(
        currency = this.currency,
        value = this.value
    )
}



