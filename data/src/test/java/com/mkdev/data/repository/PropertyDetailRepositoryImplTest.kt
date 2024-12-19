package com.mkdev.data.repository

import com.mkdev.data.datasource.mapper.ExchangeRatesDomainMapper
import com.mkdev.data.datasource.remote.api.ExchangeRatesApi
import com.mkdev.data.factory.createMockEmptyExchangeRatesModel
import com.mkdev.data.factory.createMockEmptyExchangeRatesResponse
import com.mkdev.data.factory.createMockExchangeRatesModel
import com.mkdev.data.factory.createMockExchangeRatesResponse
import io.reactivex.Single
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PropertyDetailRepositoryImplTest {

    @Mock
    private lateinit var exchangeRatesApi: ExchangeRatesApi

    @Mock
    private lateinit var exchangeRatesDomainMapper: ExchangeRatesDomainMapper

    private lateinit var propertyDetailRepositoryImpl: PropertyDetailRepositoryImpl

    @Before
    fun setUp() {
        propertyDetailRepositoryImpl =
            PropertyDetailRepositoryImpl(exchangeRatesApi, exchangeRatesDomainMapper)
    }

    @Test
    fun `getExchangeRates should return ExchangeRatesModel on success`() {
        // Given
        val exchangeRatesResponse = createMockExchangeRatesResponse()
        val expectedExchangeRatesModel = createMockExchangeRatesModel()
        `when`(exchangeRatesApi.getExchangeRates()).thenReturn(Single.just(exchangeRatesResponse))
        `when`(exchangeRatesDomainMapper.mapToExchangeRatesModel(exchangeRatesResponse)).thenReturn(
            expectedExchangeRatesModel
        )

        // When
        val result = propertyDetailRepositoryImpl.getExchangeRates().blockingGet()

        // Then
        assertEquals(expectedExchangeRatesModel, result)
        assertEquals(expectedExchangeRatesModel.rates, result.rates)
    }

    @Test
    fun `getExchangeRates should handle error from API`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(exchangeRatesApi.getExchangeRates()).thenReturn(Single.error(throwable))

        // When
        val testObserver = propertyDetailRepositoryImpl.getExchangeRates().test()

        // Then
        testObserver.assertError(throwable)
        testObserver.assertNotComplete()
    }

    @Test
    fun `getExchangeRates should return empty rates map when API response is empty`() {
        // Given
        val exchangeRatesResponse = createMockEmptyExchangeRatesResponse()
        val expectedExchangeRatesModel = createMockEmptyExchangeRatesModel()
        `when`(exchangeRatesApi.getExchangeRates()).thenReturn(Single.just(exchangeRatesResponse))
        `when`(exchangeRatesDomainMapper.mapToExchangeRatesModel(exchangeRatesResponse)).thenReturn(
            expectedExchangeRatesModel
        )

        // When
        val result = propertyDetailRepositoryImpl.getExchangeRates().blockingGet()

        // Then
        assertTrue(result.rates.isEmpty())
        assertEquals(expectedExchangeRatesModel, result)
    }
}