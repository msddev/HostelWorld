package com.mkdev.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkdev.domain.usecase.GetExchangeRatesUseCase
import com.mkdev.presentation.screen.propertyDetail.ExchangeRateUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
internal class PropertyDetailViewModel @Inject constructor(
    private val getExchangeRatesUseCase: GetExchangeRatesUseCase,
) : BaseViewModel() {

    private val _exchangeRates = MutableLiveData<ExchangeRateUiState>(ExchangeRateUiState.Loading)
    val exchangeRates: LiveData<ExchangeRateUiState> = _exchangeRates

    fun fetchExchangeRates() {
        _exchangeRates.value = ExchangeRateUiState.Loading

        getExchangeRatesUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { exchangeRatesModel ->
                    _exchangeRates.value =
                        ExchangeRateUiState.Success(data = exchangeRatesModel)
                },
                { throwable ->
                    _exchangeRates.value =
                        ExchangeRateUiState.Error(throwable = throwable)
                }
            )
            .addTo(compositeDisposable)
    }
}