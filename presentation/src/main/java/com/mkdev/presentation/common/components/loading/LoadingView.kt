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
import androidx.compose.ui.text.style.TextAlign
import com.mkdev.presentation.theme.Dimens

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
            modifier = Modifier.padding(horizontal = Dimens.paddingStandard),
            text = text,
            textAlign = TextAlign.Center,
            lineHeight = Dimens.viewTextHeight
        )
        CircularProgressIndicator(
            modifier = Modifier
                .size(Dimens.circularLoadingSizeMedium)
                .padding(top = Dimens.paddingStandard)
        )
    }
}
