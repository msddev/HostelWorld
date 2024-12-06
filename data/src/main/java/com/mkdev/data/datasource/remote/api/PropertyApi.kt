package com.mkdev.data.datasource.remote.api

import com.mkdev.data.datasource.remote.response.PropertyListResponse
import retrofit2.http.GET

interface PropertyApi {
    @GET("a1517b9da90dd6877385a65f324ffbc3/raw/058e83aa802907cb0032a15ca9054da563138541/properties.json")
    suspend fun getProperties(): PropertyListResponse
}