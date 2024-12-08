package com.mkdev.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mkdev.domain.usecase.GetPropertyListUseCase
import com.mkdev.presentation.mapper.toPropertyModel
import com.mkdev.presentation.screen.propertyList.PropertyListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
internal class PropertyListViewModel @Inject constructor(
    private val getPropertyListUseCase: GetPropertyListUseCase
) : BaseViewModel() {

    private val propertiesMutableLiveData: MutableLiveData<PropertyListUiState> by lazy {
        MutableLiveData(
            PropertyListUiState.Loading
        )
    }
    val propertiesLiveData: LiveData<PropertyListUiState> by lazy { propertiesMutableLiveData }

    init {
        //fetchPropertyList()
    }

    fun fetchPropertyList() {
        propertiesMutableLiveData.value = PropertyListUiState.Loading

        getPropertyListUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { propertyEntities ->
                    propertiesMutableLiveData.value =
                        PropertyListUiState.Success(data = propertyEntities.map { it.toPropertyModel() })
                },
                { throwable ->
                    propertiesMutableLiveData.value =
                        PropertyListUiState.Error(throwable = throwable)
                }
            )
            .addTo(compositeDisposable)
    }
}