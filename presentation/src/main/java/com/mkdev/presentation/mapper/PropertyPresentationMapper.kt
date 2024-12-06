package com.mkdev.presentation.mapper

import com.mkdev.domain.entity.DistanceEntity
import com.mkdev.domain.entity.FacilityEntity
import com.mkdev.domain.entity.FacilityListEntity
import com.mkdev.domain.entity.ImagesGalleryEntity
import com.mkdev.domain.entity.OverallRatingEntity
import com.mkdev.domain.entity.PricePerNightEntity
import com.mkdev.domain.entity.PropertyEntity
import com.mkdev.presentation.model.DistanceModel
import com.mkdev.presentation.model.FacilityListModel
import com.mkdev.presentation.model.FacilityModel
import com.mkdev.presentation.model.ImagesGalleryModel
import com.mkdev.presentation.model.OverallRatingModel
import com.mkdev.presentation.model.PricePerNightModel
import com.mkdev.presentation.model.PropertyModel

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
        lowestDormPricePerNight = this.lowestDormPricePerNight.toPricePerNightModel(),
        lowestPricePerNight = this.lowestPricePerNight.toPricePerNightModel(),
        lowestPrivatePricePerNight = this.lowestPrivatePricePerNight.toPricePerNightModel(),
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



