package com.mkdev.presentation.screen.propertyList.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.GlideImageLoader
import com.mkdev.presentation.common.utils.textSp
import com.mkdev.presentation.model.property.PropertyModel
import com.mkdev.presentation.theme.*

@Composable
internal fun PropertyItem(
    modifier: Modifier,
    property: PropertyModel,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier.padding(bottom = 8.dp),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.padding_medium)),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(
            containerColor = if(property.isFeatured) LightGreen else Color.White, // Card background color
            contentColor = Color.Black  // Card content color,e.g.text
        ),
        onClick = onItemClick,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GlideImageLoader(
                modifier = Modifier
                    .size(110.dp)
                    .padding(dimensionResource(R.dimen.padding_small))
                    .clip(RoundedCornerShape(size = dimensionResource(id = R.dimen.corner_radius_small))),
                imageUrl = property.imagesGallery.takeIf { it.isNotEmpty() }?.get(0)?.getImageUrl()
                    .orEmpty(),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = property.name,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.text_size_default).textSp,
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_2x_small)))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(dimensionResource(R.dimen.icon_size_x_small)),
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = Amber,
                    )

                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(horizontal = dimensionResource(R.dimen.padding_x_small)),
                        text = property.address1,
                        maxLines = 1,
                        fontSize = dimensionResource(R.dimen.text_size_medium).textSp,
                    )
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_2x_small)))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_x_small)),
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Amber,
                        )

                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = dimensionResource(R.dimen.padding_x_small)),
                            text = property.overallRating.convertOverallRating(),
                            maxLines = 1,
                            fontSize = dimensionResource(R.dimen.text_size_small).textSp,
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(R.dimen.padding_x_small)),
                        textAlign = TextAlign.End,
                        text = "${property.lowestPricePerNight.getCurrencySymbol()}${property.lowestPricePerNight.value}/night",
                        maxLines = 1,
                        color = Green,
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(R.dimen.text_size_default).textSp,
                    )
                }
            }
        }
    }
}