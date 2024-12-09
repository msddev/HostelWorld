package com.mkdev.data.datasource.remote.api

import io.reactivex.Completable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkStatsApi {
    @GET("6bed011203c6c8217f0d55f74ddcc5c5/raw/ce8f55cfd963aeef70f2ac9f88f34cefd19fca30/stats")
    fun trackStats(
        @Query("action") action: String,
        @Query("duration") duration: Long
    ): Completable
}