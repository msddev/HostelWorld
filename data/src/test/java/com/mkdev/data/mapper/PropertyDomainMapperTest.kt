package com.mkdev.data.mapper

import com.mkdev.data.datasource.mapper.PropertyDomainMapper
import com.mkdev.data.factory.createMockPropertyListResponse
import com.mkdev.data.factory.createMockPropertyResponse
import org.junit.Assert.assertEquals
import org.junit.Test

class PropertyDomainMapperTest {
    private val mapper = PropertyDomainMapper()

    @Test
    fun `mapToPropertyListModel should map PropertyListResponse to List of PropertyModel`() {
        // Given
        val propertyListResponse = createMockPropertyListResponse()

        // When
        val propertyModelList = mapper.mapToPropertyListModel(propertyListResponse)

        // Then
        assertEquals(2, propertyModelList.size)
        val propertyModel = propertyModelList[0]
        assertEquals("123 Main St", propertyModel.address1)
        assertEquals("Apt 4B", propertyModel.address2)
        assertEquals("km", propertyModel.distance.units)
        assertEquals(1.0, propertyModel.distance.value, 0.001)
    }

    @Test
    fun `mapToPropertyModel should map PropertyResponse to PropertyModel`() {
        // Given
        val propertyResponse = createMockPropertyResponse()

        // When
        val propertyModel = mapper.mapToPropertyModel(propertyResponse)

        // Then
        assertEquals("123 Main St", propertyModel.address1)
        assertEquals("Apt 4B", propertyModel.address2)
        assertEquals("km", propertyModel.distance.units)
        assertEquals(1.0, propertyModel.distance.value, 0.001)
    }
}