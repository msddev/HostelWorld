package com.mkdev.presentation.screen.propertyList.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mkdev.presentation.R
import com.mkdev.presentation.theme.*
import com.mkdev.presentation.theme.HostelWorldTheme

@Composable
internal fun SearchBarView(
    modifier: Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .clip(shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_x_small)))
                .background(White)
                .padding(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(dimensionResource(R.dimen.icon_size_standard)),
                painter = painterResource(id = R.drawable.ic_search_border),
                contentDescription = null,
                tint = GrayScale300,
            )

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))

            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.dublin_text),
                color = GrayScale400,
            )
        }

        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_small)))

        Icon(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_x_small)))
                .background(White)
                .padding(dimensionResource(R.dimen.padding_medium))
                .size(dimensionResource(R.dimen.icon_size_standard)),
            painter = painterResource(id = R.drawable.ic_filter_border),
            contentDescription = null,
            tint = DeepOrange,
        )
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ScreenPreview() {
    HostelWorldTheme {
        Surface {
            SearchBarView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_x_small)),
            )
        }
    }
}