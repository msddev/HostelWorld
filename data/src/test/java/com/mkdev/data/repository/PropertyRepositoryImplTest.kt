package com.mkdev.data.repository

import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.data.factory.createMockPropertyListResponse
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PropertyRepositoryImplTest {

    @Mock
    private lateinit var propertyApi: PropertyApi

    private lateinit var propertyRepositoryImpl: PropertyRepositoryImpl

    @Before
    fun setUp() {
        propertyRepositoryImpl = PropertyRepositoryImpl(propertyApi)
    }

    @Test
    fun `getProperties should return property list from API on success`() {
        // Given
        val propertyListResponse = createMockPropertyListResponse()
        `when`(propertyApi.getProperties()).thenReturn(Single.just(propertyListResponse))

        // When
        val result = propertyRepositoryImpl.getProperties().blockingGet()

        // Then
        Assert.assertEquals(propertyListResponse.properties.size, result.size)
        result.forEachIndexed { index, propertyEntity ->
            val propertyResponse = propertyListResponse.properties[index]
            Assert.assertEquals(propertyResponse.address1, propertyEntity.address1)
            Assert.assertEquals(propertyResponse.address2, propertyEntity.address2)
        }
    }

    @Test
    fun `getProperties should handle error from API`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(propertyApi.getProperties()).thenReturn(Single.error(throwable))

        // When
        val testObserver = propertyRepositoryImpl.getProperties().test()

        // Then
        testObserver.assertError(throwable)
        testObserver.assertNotComplete()
    }
}