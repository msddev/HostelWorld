package com.mkdev.data.mapper

import com.mkdev.data.datasource.mapper.toPropertyEntities
import com.mkdev.data.datasource.mapper.toPropertyEntity
import com.mkdev.data.factory.createMockPropertyListResponse
import com.mkdev.data.factory.createMockPropertyResponse
import org.junit.Assert
import org.junit.Test

class PropertyDomainMapperTest {

    @Test
    fun `toPropertyEntities should map PropertyListResponse to List of PropertyEntity`() {
        // Given
        val propertyListResponse = createMockPropertyListResponse()

        // When
        val propertyEntityList = propertyListResponse.toPropertyEntities()

        // Then
        Assert.assertEquals(propertyListResponse.properties.size, propertyEntityList.size)
        propertyEntityList.forEachIndexed { index, propertyEntity ->
            val propertyResponse = propertyListResponse.properties[index]
            Assert.assertEquals(propertyResponse.address1, propertyEntity.address1)
            Assert.assertEquals(propertyResponse.address2, propertyEntity.address2)
        }
    }

    @Test
    fun `toPropertyEntity should map PropertyResponse to PropertyEntity`() {
        // Given
        val propertyResponse = createMockPropertyResponse()

        // When
        val propertyEntity = propertyResponse.toPropertyEntity()

        // Then
        Assert.assertEquals(propertyResponse.address1, propertyEntity.address1)
        Assert.assertEquals(propertyResponse.address2, propertyEntity.address2)
    }
}