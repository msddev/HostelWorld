package com.mkdev.data.repository

import com.mkdev.data.datasource.remote.api.ExchangeRatesApi
import com.mkdev.data.factory.createMockEmptyExchangeRatesResponse
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

    private lateinit var propertyDetailRepositoryImpl: PropertyDetailRepositoryImpl

    @Before
    fun setUp() {
        propertyDetailRepositoryImpl = PropertyDetailRepositoryImpl(exchangeRatesApi)
    }

    @Test
    fun `getExchangeRates should return ExchangeRatesEntity on success`() {
        // Given
        val exchangeRatesResponse = createMockExchangeRatesResponse()
        `when`(exchangeRatesApi.getExchangeRates()).thenReturn(Single.just(exchangeRatesResponse))

        // When
        val result = propertyDetailRepositoryImpl.getExchangeRates().blockingGet()

        // Then
        assertEquals(
            exchangeRatesResponse.rates,
            result.rates
        )
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
        `when`(exchangeRatesApi.getExchangeRates()).thenReturn(Single.just(exchangeRatesResponse))

        // When
        val result = propertyDetailRepositoryImpl.getExchangeRates().blockingGet()

        // Then
        assertTrue(result.rates.isEmpty())
    }
}