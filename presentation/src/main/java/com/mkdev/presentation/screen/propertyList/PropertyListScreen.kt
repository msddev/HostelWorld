package com.mkdev.presentation.screen.propertyList

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .clickable {
                navigateToPropertyDetailScreen.invoke()
            }
    ) {

    }
}
