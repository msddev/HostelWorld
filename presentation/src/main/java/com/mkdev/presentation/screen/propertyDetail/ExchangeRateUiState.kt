package com.mkdev.presentation.screen.propertyDetail

import com.mkdev.presentation.model.exchangeRates.ExchangeRatesModel

internal sealed class ExchangeRateUiState {
    object Loading : ExchangeRateUiState()
    data class Success(val data: ExchangeRatesModel?) : ExchangeRateUiState()
    data class Error(val throwable: Throwable) : ExchangeRateUiState()
}