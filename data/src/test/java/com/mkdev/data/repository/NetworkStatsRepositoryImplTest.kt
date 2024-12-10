package com.mkdev.data.repository

import com.mkdev.data.datasource.remote.api.NetworkStatsApi
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class NetworkStatsRepositoryImplTest {

    @Mock
    private lateinit var networkStatsApi: NetworkStatsApi

    private lateinit var networkStatsRepositoryImpl: NetworkStatsRepositoryImpl

    @Before
    fun setUp() {
        networkStatsRepositoryImpl = NetworkStatsRepositoryImpl(networkStatsApi)
    }

    @Test
    fun `trackNetworkStats should call networkStatsApi and complete successfully`() {
        // Given
        val action = "load_properties"
        val duration = 300L
        `when`(networkStatsApi.trackStats(action, duration)).thenReturn(Completable.complete())

        // When
        val testObserver = networkStatsRepositoryImpl.trackNetworkStats(action, duration).test()

        // Then
        testObserver.assertComplete()
        verify(networkStatsApi).trackStats(action, duration)
    }

    @Test
    fun `trackNetworkStats should handle error from networkStatsApi`() {
        // Given
        val action = "load_properties"
        val duration = 300L
        val throwable = Throwable("Network error")
        `when`(networkStatsApi.trackStats(action, duration)).thenReturn(Completable.error(throwable))

        // When
        val testObserver = networkStatsRepositoryImpl.trackNetworkStats(action, duration).test()

        // Then
        testObserver.assertError(throwable)
        testObserver.assertNotComplete()
        verify(networkStatsApi).trackStats(action, duration)
    }
}