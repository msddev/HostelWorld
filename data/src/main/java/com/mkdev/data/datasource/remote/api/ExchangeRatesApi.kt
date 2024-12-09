package com.mkdev.data.datasource.remote.api

import com.mkdev.data.datasource.remote.response.exchangeRates.ExchangeRatesResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ExchangeRatesApi {
    @GET("16e87e40ca7b9650aa8e1b936f23e14e/raw/15efd901b57c2b66bf0201ee7aa9aa2edc6df779/rates.json")
    fun getExchangeRates(): Single<ExchangeRatesResponse>
}