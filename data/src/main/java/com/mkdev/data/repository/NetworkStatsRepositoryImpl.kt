package com.mkdev.data.repository

import com.mkdev.data.datasource.remote.api.NetworkStatsApi
import com.mkdev.domain.repository.NetworkStatsRepository
import io.reactivex.Completable
import javax.inject.Inject

class NetworkStatsRepositoryImpl @Inject constructor(
    private val networkStatsApi: NetworkStatsApi
) : NetworkStatsRepository {

    override fun trackNetworkStats(action: String, duration: Long): Completable {
        return networkStatsApi.trackStats(action, duration)
    }
}