package com.mkdev.presentation.screen.propertyDetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mkdev.presentation.mockData.mockPropertyItem
import com.mkdev.presentation.screen.propertyDetail.components.PropertyDetailContent

@Composable
internal fun PropertyDetailScreen(
    onBackClick: () -> Unit,
) {
    PropertyDetailContent(
        modifier = Modifier.fillMaxSize(),
        property = mockPropertyItem,
        onBackClick = {

        }
    )
}
