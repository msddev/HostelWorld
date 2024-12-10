package com.mkdev.presentation.mapper

import com.mkdev.presentation.factory.createMockDistanceEntity
import com.mkdev.presentation.factory.createMockFacilityEntity
import com.mkdev.presentation.factory.createMockFacilityListEntity
import com.mkdev.presentation.factory.createMockImagesGalleryEntity
import com.mkdev.presentation.factory.createMockOverallRatingEntity
import com.mkdev.presentation.factory.createMockPricePerNightEntity
import org.junit.Assert
import org.junit.Test

class PropertyMapperTest {

    @Test
    fun `toDistanceModel should map DistanceEntity to DistanceModel`() {
        // Given
        val distanceEntity = createMockDistanceEntity()

        // When
        val distanceModel = distanceEntity.toDistanceModel()

        // Then
        Assert.assertEquals(distanceEntity.units, distanceModel.units)
        Assert.assertEquals(distanceEntity.value, distanceModel.value, distanceModel.value)
    }

    @Test
    fun `toFacilityModel should map FacilityEntity to FacilityModel`() {
        // Given
        val facilityEntity = createMockFacilityEntity()

        // When
        val facilityModel = facilityEntity.toFacilityModel()

        // Then
        Assert.assertEquals(facilityEntity.id, facilityModel.id)
        Assert.assertEquals(facilityEntity.name, facilityModel.name)
    }

    @Test
    fun `toFacilityListModel should map FacilityListEntity to FacilityListModel`() {
        // Given
        val facilityListEntity = createMockFacilityListEntity()

        // When
        val facilityListModel = facilityListEntity.toFacilityListModel()

        // Then
        Assert.assertEquals(facilityListEntity.facilities.size, facilityListModel.facilities.size)
        Assert.assertEquals(facilityListEntity.name, facilityListModel.name)
        Assert.assertEquals(facilityListEntity.id, facilityListModel.id)
    }

    @Test
    fun `toImagesGalleryModel should map ImagesGalleryEntity to ImagesGalleryModel`() {
        // Given
        val imagesGalleryEntity = createMockImagesGalleryEntity()

        // When
        val imagesGalleryModel = imagesGalleryEntity.toImagesGalleryModel()

        // Then
        Assert.assertEquals(imagesGalleryEntity.prefix, imagesGalleryModel.prefix)
        Assert.assertEquals(imagesGalleryEntity.suffix, imagesGalleryModel.suffix)
    }

    @Test
    fun `toOverallRatingModel should map OverallRatingEntity to OverallRatingModel`() {
        // Given
        val overallRatingEntity = createMockOverallRatingEntity()

        // When
        val overallRatingModel = overallRatingEntity.toOverallRatingModel()

        // Then
        Assert.assertEquals(overallRatingEntity.numberOfRatings, overallRatingModel.numberOfRatings)
        Assert.assertEquals(overallRatingEntity.overall, overallRatingModel.overall)
    }

    @Test
    fun `toPricePerNightModel should map PricePerNightEntity to PricePerNightModel`() {
        // Given
        val pricePerNightEntity = createMockPricePerNightEntity()

        // When
        val pricePerNightModel = pricePerNightEntity.toPricePerNightModel()

        // Then
        Assert.assertEquals(pricePerNightEntity.currency, pricePerNightModel.currency)
        Assert.assertEquals(pricePerNightEntity.value, pricePerNightModel.value)
    }
}