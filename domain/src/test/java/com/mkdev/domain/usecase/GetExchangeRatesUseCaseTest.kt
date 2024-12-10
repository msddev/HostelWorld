package com.mkdev.domain.usecase

import com.mkdev.domain.factory.createMockExchangeRatesEntity
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyDetailRepository
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetExchangeRatesUseCaseTest {

    @Mock
    private lateinit var propertyDetailRepository: PropertyDetailRepository

    @Mock
    private lateinit var networkStatsRepository: NetworkStatsRepository

    private lateinit var getExchangeRatesUseCase: GetExchangeRatesUseCase

    @Before
    fun setUp() {
        getExchangeRatesUseCase = GetExchangeRatesUseCase(
            propertyDetailRepository = propertyDetailRepository,
            networkStatsRepository = networkStatsRepository
        )
    }

    @Test
    fun `invoke should return exchange rate list from repository on success`() {
        // Given
        val exchangeRatesEntity = createMockExchangeRatesEntity()
        `when`(propertyDetailRepository.getExchangeRates()).thenReturn(
            Single.just(
                exchangeRatesEntity
            )
        )
        `when`(networkStatsRepository.trackNetworkStats(anyString(), anyLong())).thenReturn(
            Completable.complete()
        )

        // When
        val result = getExchangeRatesUseCase().blockingGet()

        // Then
        Assert.assertEquals(exchangeRatesEntity, result)
        verify(networkStatsRepository).trackNetworkStats(
            anyString(),
            anyLong()
        )
    }

    @Test
    fun `invoke should handle error from property detail repository and should never invoke network stats tracking`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(propertyDetailRepository.getExchangeRates()).thenReturn(Single.error(throwable))

        // When
        val testObserver = getExchangeRatesUseCase().test()

        // Then
        testObserver.assertError(throwable)
        testObserver.assertNotComplete()
        verify(networkStatsRepository, never()).trackNetworkStats(anyString(), anyLong())
    }

    @Test
    fun `invoke should handle error during network stats tracking`() {
        // Given
        val exchangeRatesEntity = createMockExchangeRatesEntity()
        `when`(propertyDetailRepository.getExchangeRates()).thenReturn(
            Single.just(
                exchangeRatesEntity
            )
        )
        val trackingError = Throwable("Tracking error")
        `when`(networkStatsRepository.trackNetworkStats(anyString(), anyLong())).thenReturn(
            Completable.error(trackingError)
        )

        // When
        val result = getExchangeRatesUseCase().blockingGet()

        // Then
        Assert.assertEquals(exchangeRatesEntity, result) // Should still return exchange rates
        verify(networkStatsRepository).trackNetworkStats(anyString(), anyLong())
    }

    @Test
    fun `invoke should return consistent exchange rates across multiple calls`() {
        // Given
        val exchangeRatesEntity = createMockExchangeRatesEntity()
        `when`(propertyDetailRepository.getExchangeRates()).thenReturn(Single.just(exchangeRatesEntity))
        `when`(networkStatsRepository.trackNetworkStats(anyString(), anyLong())).thenReturn(Completable.complete())

        // When
        val result1 = getExchangeRatesUseCase().blockingGet()
        val result2 = getExchangeRatesUseCase().blockingGet() // Call the Use Case again

        // Then
        Assert.assertEquals(result1, result2) // Verify consistency
        verify(networkStatsRepository, times(2)).trackNetworkStats(anyString(), anyLong())
    }
}