package com.mkdev.presentation.screen.propertyDetail

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkdev.domain.model.property.PricePerNightModel
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.error.ErrorView
import com.mkdev.presentation.screen.propertyDetail.components.ExchangeRateDialog
import com.mkdev.presentation.screen.propertyDetail.components.PropertyDetailContent
import com.mkdev.presentation.viewmodel.PropertyDetailViewModel
import com.mkdev.presentation.viewmodel.SharedViewModel
import java.util.Locale

@Composable
internal fun PropertyDetailScreen(
    propertyDetailViewModel: PropertyDetailViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = hiltViewModel(LocalContext.current as ComponentActivity),
    onBackClick: () -> Unit,
) {
    var exchangeRateDialogVisibility by remember { mutableStateOf(false) }
    var exchangeRates by remember { mutableStateOf<Map<String, Double>?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    sharedViewModel.selectedProperty.observeAsState().value?.let { selectedProperty ->
        PropertyDetailContent(
            modifier = Modifier.fillMaxSize(),
            property = selectedProperty,
            onCurrencyFilterClick = {
                exchangeRateDialogVisibility = true
                propertyDetailViewModel.fetchExchangeRates()
            },
            onBackClick = onBackClick,
            onReservedClick = {
                // TODO: there is no implementation!
            }
        )
    } ?: run {
        ErrorView(
            text = stringResource(R.string.no_results_found),
            actionButtonText = stringResource(R.string.back_to_home),
            onAction = onBackClick
        )
    }

    when (val uiState = propertyDetailViewModel.exchangeRates.observeAsState().value) {
        is ExchangeRateUiState.Loading, null -> {
            isLoading = true
        }

        is ExchangeRateUiState.Success -> {
            isLoading = false
            exchangeRates = uiState.data?.rates
        }

        is ExchangeRateUiState.Error -> {
            isLoading = false
            exchangeRateDialogVisibility = false

            Toast.makeText(
                LocalContext.current,
                uiState.throwable.message ?: stringResource(R.string.oops_something_went_wrong),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    ExchangeRateDialog(
        exchangeRateDialogVisibility = exchangeRateDialogVisibility,
        isLoading = isLoading,
        exchangeRates = exchangeRates,
        onCurrencySelected = { currencyCode, exchangeRate ->
            exchangeRateDialogVisibility = false

            val targetPrice = PricePerNightModel(currencyCode, exchangeRate.toString())

            sharedViewModel.getPropertyBasePrice()?.let { basePrice ->
                val updatedPrice = updateCurrencyValue(
                    basePrice = basePrice,
                    targetPrice = targetPrice
                )

                val updatedProperty = sharedViewModel.selectedProperty.value?.copy(
                    lowestPricePerNight = PricePerNightModel(
                        currency = updatedPrice.currency,
                        value = updatedPrice.value
                    )
                )
                sharedViewModel.setSelectedProperty(updatedProperty!!)
            }
        },
        onDismiss = {
            exchangeRateDialogVisibility = false
        }
    )
}

private fun updateCurrencyValue(
    basePrice: PricePerNightModel,
    targetPrice: PricePerNightModel
): PricePerNightModel {
    val basePriceValue = basePrice.value.toDoubleOrNull() ?: 0.0
    val targetPriceValue = targetPrice.value.toDoubleOrNull() ?: 0.0

    val newPriceValue = basePriceValue * targetPriceValue

    return PricePerNightModel(
        currency = targetPrice.currency,
        value = String.format(locale = Locale.US, "%.2f", newPriceValue).toString()
    )
}
