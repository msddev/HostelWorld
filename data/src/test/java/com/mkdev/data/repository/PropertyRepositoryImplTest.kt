package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.PropertyDomainMapper
import com.mkdev.data.datasource.remote.api.PropertyApi
import com.mkdev.data.factory.createMockPropertyListModel
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

    @Mock
    private lateinit var propertyDomainMapper: PropertyDomainMapper

    private lateinit var propertyRepositoryImpl: PropertyRepositoryImpl

    @Before
    fun setUp() {
        propertyRepositoryImpl = PropertyRepositoryImpl(propertyApi, propertyDomainMapper)
    }

    @Test
    fun `getProperties should return property list from API on success`() {
        // Given
        val propertyListResponse = createMockPropertyListResponse()
        val expectedPropertyModelList = createMockPropertyListModel()
        `when`(propertyApi.getProperties()).thenReturn(Single.just(propertyListResponse))
        `when`(propertyDomainMapper.mapToPropertyListModel(propertyListResponse)).thenReturn(
            expectedPropertyModelList
        )

        // When
        val result = propertyRepositoryImpl.getProperties().blockingGet()

        // Then
        Assert.assertEquals(expectedPropertyModelList.size, result.size)
        Assert.assertEquals(expectedPropertyModelList[0].address1, result[0].address1)
        Assert.assertEquals(expectedPropertyModelList[0].address2, result[0].address2)
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