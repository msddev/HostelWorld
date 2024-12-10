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
import com.mkdev.presentation.R
import com.mkdev.presentation.common.utils.textSp

@Composable
fun ErrorView(
    modifier: Modifier = Modifier,
    text: String,
    actionButtonText: String = stringResource(R.string.retry),
    onAction: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_standard)),
            text = text,
            textAlign = TextAlign.Center,
            lineHeight = dimensionResource(R.dimen.view_text_height).textSp
        )

        Icon(
            imageVector = Icons.Filled.Face,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(R.dimen.icon_size_x_large))
                .padding(top = dimensionResource(R.dimen.padding_standard)),
        )

        Button(
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_standard)),
            onClick = onAction
        ) {
            Text(text = actionButtonText)
        }
    }
}
