package com.mkdev.presentation.screen.propertyDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mkdev.presentation.theme.*

@Composable
internal fun ChipItemView(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .background(
                Colors.LightGreen,
                shape = RoundedCornerShape(Dimens.cornerRadiusSmall)
            )
            .padding(
                horizontal = Dimens.paddingXSmall,
                vertical = Dimens.padding2xSmall
            ),
        color = Colors.GrayScale500,
        style = MaterialTheme.typography.labelLarge,
    )
}