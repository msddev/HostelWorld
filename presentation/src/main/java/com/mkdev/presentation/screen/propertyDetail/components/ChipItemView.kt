package com.mkdev.presentation.screen.propertyDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.mkdev.presentation.R
import com.mkdev.presentation.common.utils.textSp
import com.mkdev.presentation.theme.*

@Composable
internal fun ChipItemView(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .background(
                LightGreen,
                shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_x_large))
            )
            .padding(horizontal = dimensionResource(R.dimen.padding_2x_small), vertical = dimensionResource(R.dimen.padding_3x_small)),
        color = GrayScale600,
        fontSize = dimensionResource(R.dimen.text_size_small).textSp,
    )
}