package com.mkdev.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.mkdev.domain.unit.Resource
import com.mkdev.domain.usecase.GetPropertyListUseCase
import com.mkdev.presentation.mapper.toPropertyModel
import com.mkdev.presentation.screen.propertyList.PropertyListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.let

@HiltViewModel
internal class PropertyListViewModel @Inject constructor(
    private val getPropertyListUseCase: GetPropertyListUseCase
) : androidx.lifecycle.ViewModel() {

    private val _state = MutableStateFlow<PropertyListUiState>(PropertyListUiState.Loading)
    val state = _state.asStateFlow()

    fun fetchProperties() {
        viewModelScope.launch {
            getPropertyListUseCase().onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = PropertyListUiState.Loading
                    }

                    is Resource.Success -> {
                        result.data?.let { propertyEntities ->
                            _state.value =
                                PropertyListUiState.Success(data = propertyEntities.map { it.toPropertyModel() })
                        }
                    }

                    is Resource.Error -> {
                        _state.value = PropertyListUiState.Error(
                            message = result.message
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}