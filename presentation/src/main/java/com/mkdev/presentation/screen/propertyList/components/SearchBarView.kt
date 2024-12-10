package com.mkdev.presentation.screen.propertyList.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mkdev.presentation.R
import com.mkdev.presentation.theme.Colors
import com.mkdev.presentation.theme.Dimens

@Composable
internal fun SearchBarView(
    modifier: Modifier,
) {
    Surface(
        modifier = modifier,
        shadowElevation = Dimens.cardElevation1dp
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(Dimens.cornerRadiusXSmall))
                .background(Color.White)
                .padding(Dimens.paddingMedium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(Dimens.iconSizeStandard),
                painter = painterResource(id = R.drawable.ic_search_border),
                contentDescription = null,
                tint = Colors.GrayScale300,
            )

            Spacer(modifier = Modifier.width(Dimens.paddingMedium))

            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.dublin_text),
                color = Colors.GrayScale400,
            )
        }
    }
}