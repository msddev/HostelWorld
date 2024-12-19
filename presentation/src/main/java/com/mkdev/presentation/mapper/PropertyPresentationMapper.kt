package com.mkdev.presentation.mapper

import com.mkdev.domain.model.property.DistanceModel
import com.mkdev.domain.model.property.FacilityListModel
import com.mkdev.domain.model.property.FacilityModel
import com.mkdev.domain.model.property.ImagesGalleryModel
import com.mkdev.domain.model.property.OverallRatingModel
import com.mkdev.domain.model.property.PricePerNightModel
import com.mkdev.domain.model.property.PropertyModel

internal fun PropertyModel.toPropertyModel(): PropertyModel {
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

internal fun DistanceModel.toDistanceModel(): DistanceModel {
    return DistanceModel(
        units = this.units,
        value = this.value
    )
}

internal fun FacilityModel.toFacilityModel(): FacilityModel {
    return FacilityModel(
        id = this.id,
        name = this.name
    )
}

internal fun FacilityListModel.toFacilityListModel(): FacilityListModel {
    return FacilityListModel(
        facilities = this.facilities.map { it.toFacilityModel() },
        name = this.name,
        id = this.id
    )
}

internal fun ImagesGalleryModel.toImagesGalleryModel(): ImagesGalleryModel {
    return ImagesGalleryModel(
        prefix = this.prefix,
        suffix = this.suffix
    )
}

internal fun OverallRatingModel.toOverallRatingModel(): OverallRatingModel {
    return OverallRatingModel(
        numberOfRatings = this.numberOfRatings,
        overall = this.overall
    )
}

internal fun PricePerNightModel.toPricePerNightModel(): PricePerNightModel {
    return PricePerNightModel(
        currency = this.currency,
        value = this.value
    )
}



