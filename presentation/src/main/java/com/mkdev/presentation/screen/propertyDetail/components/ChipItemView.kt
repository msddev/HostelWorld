package com.mkdev.presentation.screen.propertyDetail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import com.mkdev.presentation.R
import com.mkdev.presentation.common.utils.textSp
import com.mkdev.presentation.theme.*

@Composable
internal fun ChipItemView(text: String, icon: Painter) {
    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_medium)),
            painter = icon,
            contentDescription = null,
            tint = Amber,
        )

        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = dimensionResource(R.dimen.padding_2x_small)),
            text = text,
            maxLines = 1,
            color = GrayScale600,
            fontSize = dimensionResource(R.dimen.text_size_small).textSp,
        )
    }
}