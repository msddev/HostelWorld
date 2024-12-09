package com.mkdev.domain.repository

import io.reactivex.Completable

interface NetworkStatsRepository {
    fun trackNetworkStats(action: String, duration: Long): Completable
}