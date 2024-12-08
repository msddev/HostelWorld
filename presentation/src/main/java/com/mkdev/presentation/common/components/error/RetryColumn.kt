package com.mkdev.presentation.common.components.error

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mkdev.presentation.R

@Composable
fun RetryColumn(
    modifier: Modifier = Modifier,
    message: String,
    onRetry: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_standard)),
            text = message,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        Icon(
            imageVector = Icons.Filled.Face,
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .padding(top = dimensionResource(R.dimen.padding_standard)),
        )

        Button(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_standard)),
            onClick = onRetry
        ) {
            Text(text = stringResource(R.string.retry))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ErrorColumnPreview() {
    RetryColumn(message = "Oops!", onRetry = {})
}
