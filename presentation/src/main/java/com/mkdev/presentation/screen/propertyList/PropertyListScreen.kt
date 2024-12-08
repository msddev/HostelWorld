package com.mkdev.presentation.screen.propertyList

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.presentation.R
import com.mkdev.presentation.mockData.mockPropertyList
import com.mkdev.presentation.screen.propertyList.components.PropertyListContent
import com.mkdev.presentation.viewmodel.PropertyListViewModel

@Composable
internal fun PropertyListScreen(
    viewModel: PropertyListViewModel = hiltViewModel(),
    navigateToPropertyDetailScreen: () -> Unit,
) {

    when (viewModel.propertiesLiveData.observeAsState().value) {
        is PropertyListUiState.Loading -> {
            Log.d("massss", "Loading: ")
        }

        is PropertyListUiState.Success -> {

            Log.d("massss", "Success: ")
        }

        else -> {

            Log.d("massss", "error: ")
        }
    }

    PropertyListContent(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_x_small)),
        featuredProperties = mockPropertyList,
        normalProperties = mockPropertyList,
        onItemClick = {

        },
    )
}
