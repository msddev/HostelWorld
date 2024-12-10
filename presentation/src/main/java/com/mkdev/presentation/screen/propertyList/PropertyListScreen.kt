package com.mkdev.presentation.screen.propertyList

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.error.ErrorView
import com.mkdev.presentation.common.components.loading.LoadingView
import com.mkdev.presentation.screen.propertyList.components.PropertyListContent
import com.mkdev.presentation.viewmodel.PropertyListViewModel
import com.mkdev.presentation.viewmodel.SharedViewModel

@Composable
internal fun PropertyListScreen(
    propertyListViewModel: PropertyListViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    navigateToPropertyDetailScreen: () -> Unit,
) {
    val listState: LazyListState = rememberLazyListState()
    var hasFetchedData by rememberSaveable { mutableStateOf<Boolean>(false) }

    val uiState = propertyListViewModel.properties.observeAsState().value

    if (hasFetchedData.not()) {
        propertyListViewModel.fetchPropertyList()
        hasFetchedData = true
    }

    when (uiState) {
        is PropertyListUiState.Loading, null -> {
            LoadingView(text = stringResource(id = R.string.searching_text))
        }

        is PropertyListUiState.Success -> {
            if (uiState.data.isEmpty()) {
                ErrorView(
                    text = stringResource(R.string.no_results_found),
                    onAction = {
                        propertyListViewModel.fetchPropertyList()
                    }
                )
                return
            }

            val (featuredProperties, normalProperties) = uiState.data.partition { it.isFeatured }

            PropertyListContent(
                modifier = Modifier.fillMaxSize(),
                listState = listState,
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
            ErrorView(
                text = uiState.throwable.message
                    ?: stringResource(R.string.oops_something_went_wrong),
                onAction = {
                    propertyListViewModel.fetchPropertyList()
                }
            )
        }
    }
}
