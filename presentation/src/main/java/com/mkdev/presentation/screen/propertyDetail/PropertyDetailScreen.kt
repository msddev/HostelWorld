package com.mkdev.presentation.screen.propertyDetail

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.error.ErrorColumn
import com.mkdev.presentation.screen.propertyDetail.components.PropertyDetailContent
import com.mkdev.presentation.viewmodel.SharedViewModel

@Composable
internal fun PropertyDetailScreen(
    sharedViewModel: SharedViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onBackClick: () -> Unit,
) {
    sharedViewModel.selectedProperty.observeAsState().value?.let { selectedProperty ->
        PropertyDetailContent(
            modifier = Modifier.fillMaxSize(),
            property = selectedProperty,
            onBackClick = onBackClick
        )
    } ?: run {
        ErrorColumn(
            message = stringResource(R.string.no_results_found),
            actionButtonText = stringResource(R.string.back_to_home),
            onAction = onBackClick
        )
    }
}
