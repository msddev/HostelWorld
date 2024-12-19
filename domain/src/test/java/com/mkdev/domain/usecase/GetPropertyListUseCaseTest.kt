package com.mkdev.domain.usecase

import com.mkdev.domain.factory.createMockPropertyModelList
import com.mkdev.domain.repository.NetworkStatsRepository
import com.mkdev.domain.repository.PropertyRepository
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
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPropertyListUseCaseTest {

    @Mock
    private lateinit var propertyRepository: PropertyRepository

    @Mock
    private lateinit var networkStatsRepository: NetworkStatsRepository

    private lateinit var getPropertyListUseCase: GetPropertyListUseCase

    @Before
    fun setUp() {
        getPropertyListUseCase = GetPropertyListUseCase(
            propertyRepository = propertyRepository,
            networkStatsRepository = networkStatsRepository
        )
    }

    @Test
    fun `invoke should return property list from repository on success`() {
        // Given
        val propertyModelList = createMockPropertyModelList()
        `when`(propertyRepository.getProperties()).thenReturn(Single.just(propertyModelList))
        `when`(
            networkStatsRepository.trackNetworkStats(
                action = anyString(),
                duration = anyLong()
            )
        ).thenReturn(
            Completable.complete()
        )

        // When
        val result = getPropertyListUseCase().blockingGet()

        // Then
        Assert.assertEquals(propertyModelList, result)
        verify(networkStatsRepository).trackNetworkStats(
            action = anyString(),
            duration = anyLong()
        )
    }

    @Test
    fun `invoke should handle error from property repository and should never invoke network stats tracking`() {
        // Given
        val throwable = Throwable("Network error")
        `when`(propertyRepository.getProperties()).thenReturn(Single.error(throwable))

        // When
        val result = getPropertyListUseCase()
            .test()
            .assertError(throwable)
            .assertNotComplete()
            .values()

        // Then
        Assert.assertTrue(result.isEmpty())
        verify(networkStatsRepository, never()).trackNetworkStats(anyString(), anyLong())
    }

    @Test
    fun `invoke should handle error during network stats tracking`() {
        // Given
        val propertyModelList = createMockPropertyModelList()
        `when`(propertyRepository.getProperties()).thenReturn(Single.just(propertyModelList))
        val trackingError = Throwable("Tracking error")
        `when`(networkStatsRepository.trackNetworkStats(anyString(), anyLong())).thenReturn(Completable.error(trackingError))

        // When
        val result = getPropertyListUseCase().blockingGet()

        // Then
        Assert.assertEquals(propertyModelList, result) // Should still return the property list
        verify(networkStatsRepository).trackNetworkStats(anyString(), anyLong())
    }

    @Test
    fun `invoke should return empty list when repository return empty list`() {
        // Given
        `when`(propertyRepository.getProperties()).thenReturn(Single.just(emptyList()))
        `when`(networkStatsRepository.trackNetworkStats(anyString(), anyLong())).thenReturn(Completable.complete())

        // When
        val result = getPropertyListUseCase().blockingGet()

        // Then
        Assert.assertTrue(result.isEmpty())
        verify(networkStatsRepository).trackNetworkStats(anyString(), anyLong())
    }
}