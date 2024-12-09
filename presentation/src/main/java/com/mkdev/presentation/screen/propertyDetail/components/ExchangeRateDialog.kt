package com.mkdev.presentation.screen.propertyDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.mkdev.presentation.R
import com.mkdev.presentation.screen.propertyDetail.components.topAppBar.TopAppBarTitle

@Composable
internal fun ExchangeRateDialog(
    exchangeRateDialogVisibility: Boolean,
    isLoading: Boolean,
    exchangeRates: Map<String, Double>?,
    onCurrencySelected: (String, Double) -> Unit,
    onDismiss: () -> Unit,
) {
    val currencyMapping = mapOf(
        "EUR" to "Euro (EUR)",
        "USD" to "US Dollar (USD)",
        "GBP" to "British Pound (GBP)"
    )

    if (exchangeRateDialogVisibility) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
                .clickable(
                    onClick = onDismiss,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() })
        ) {
            Card(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(dimensionResource(R.dimen.padding_standard))
                    .clickable(
                        onClick = {},
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }),
                elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation_6dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White, // Card background color
                    contentColor = Color.Black  // Card content color,e.g.text
                ),
            ) {
                Column(modifier = Modifier.padding(dimensionResource(R.dimen.padding_standard))) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TopAppBarTitle(
                            modifier = Modifier.weight(1f),
                            title = stringResource(R.string.currency_exchange),
                            textAlign = TextAlign.Center
                        )

                        IconButton(
                            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_standard)),
                            onClick = onDismiss
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                tint = Color.Black,
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))

                    if (isLoading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    } else if (exchangeRates.isNullOrEmpty().not()) {
                        LazyColumn {
                            items(currencyMapping.keys.toList()) { currencyCode ->
                                val currencyName = currencyMapping[currencyCode] ?: currencyCode
                                val exchangeRate = exchangeRates[currencyCode] ?: 0.0

                                Text(
                                    text = currencyName,
                                    modifier = Modifier
                                        .clickable {
                                            onCurrencySelected(currencyCode, exchangeRate)
                                        }
                                        .fillMaxWidth()
                                        .padding(dimensionResource(R.dimen.padding_small))
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}