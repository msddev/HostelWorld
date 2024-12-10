package com.mkdev.presentation.common.components.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.mkdev.presentation.R
import com.mkdev.presentation.common.utils.textSp

@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
    text: String,
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
        CircularProgressIndicator(
            modifier = Modifier
                .size(dimensionResource(R.dimen.circular_loading_size_medium))
                .padding(top = dimensionResource(R.dimen.padding_standard))
        )
    }
}
