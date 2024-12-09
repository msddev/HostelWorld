package com.mkdev.presentation.screen.propertyList

import com.mkdev.presentation.model.property.PropertyModel

internal sealed class PropertyListUiState {
    object Loading : PropertyListUiState()
    data class Success(val data: List<PropertyModel>) : PropertyListUiState()
    data class Error(val throwable: Throwable) : PropertyListUiState()
}