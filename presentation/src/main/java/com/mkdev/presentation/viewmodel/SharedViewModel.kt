package com.mkdev.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mkdev.presentation.model.PropertyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SharedViewModel @Inject constructor() : ViewModel() {
    private val _selectedProperty = MutableLiveData<PropertyModel?>(null)
    val selectedProperty: LiveData<PropertyModel?> = _selectedProperty

    fun setSelectedProperty(property: PropertyModel) {
        _selectedProperty.value = property
    }
}