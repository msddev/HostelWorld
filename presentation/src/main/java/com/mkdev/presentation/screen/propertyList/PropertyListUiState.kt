package com.mkdev.presentation.screen.propertyList

import com.mkdev.presentation.model.PropertyModel

internal sealed class PropertyListUiState {
    data object Loading : PropertyListUiState()
    data class Success(val data: List<PropertyModel> = emptyList()) : PropertyListUiState()
    data class Error(val message: Int? = null) : PropertyListUiState()
}