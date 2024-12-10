package com.mkdev.presentation.screen.propertyList

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.error.ErrorColumn
import com.mkdev.presentation.common.components.loading.LoadingColumn
import com.mkdev.presentation.screen.propertyList.components.PropertyListContent
import com.mkdev.presentation.viewmodel.PropertyListViewModel
import com.mkdev.presentation.viewmodel.SharedViewModel

@Composable
internal fun PropertyListScreen(
    propertyListViewModel: PropertyListViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToPropertyDetailScreen: () -> Unit,
) {
    LaunchedEffect(Unit) {
        propertyListViewModel.fetchPropertyList()
    }

    when (val uiState = propertyListViewModel.properties.observeAsState().value) {
        is PropertyListUiState.Loading, null -> {
            LoadingColumn(stringResource(id = R.string.searching_text))
        }

        is PropertyListUiState.Success -> {
            if (uiState.data.isEmpty()) {
                ErrorColumn(
                    message = stringResource(R.string.no_results_found),
                    onAction = {
                        propertyListViewModel.fetchPropertyList()
                    }
                )
                return
            }

            val (featuredProperties, normalProperties) = uiState.data.partition { it.isFeatured }

            PropertyListContent(
                modifier = Modifier.fillMaxSize(),
                featuredProperties = featuredProperties,
                normalProperties = normalProperties,
                onItemClick = { selectedProperty ->
                    sharedViewModel.setSelectedProperty(selectedProperty)
                    sharedViewModel.setPropertyBasePrice(selectedProperty.lowestPricePerNight)
                    navigateToPropertyDetailScreen.invoke()
                }
            )
        }

        is PropertyListUiState.Error -> {
            ErrorColumn(
                message = uiState.throwable.message
                    ?: stringResource(R.string.oops_something_went_wrong),
                onAction = {
                    propertyListViewModel.fetchPropertyList()
                }
            )
        }
    }
}
