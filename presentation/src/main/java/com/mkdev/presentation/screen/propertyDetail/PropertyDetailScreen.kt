package com.mkdev.presentation.screen.propertyDetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.presentation.mockData.mockPropertyItem
import com.mkdev.presentation.screen.propertyDetail.components.PropertyDetailContent
import com.mkdev.presentation.viewmodel.SharedViewModel

@Composable
internal fun PropertyDetailScreen(
    sharedViewModel: SharedViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val selectedProperty = sharedViewModel.selectedProperty.observeAsState()

    PropertyDetailContent(
        modifier = Modifier.fillMaxSize(),
        property = mockPropertyItem,
        onBackClick = {

        }
    )
}
