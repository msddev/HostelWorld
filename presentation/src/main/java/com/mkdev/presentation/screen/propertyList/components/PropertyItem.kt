package com.mkdev.presentation.screen.propertyList.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mkdev.domain.model.property.PropertyModel
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.GlideImageLoader
import com.mkdev.presentation.theme.*

@Composable
internal fun PropertyItem(
    modifier: Modifier,
    property: PropertyModel,
    onItemClick: () -> Unit,
) {
    Card(
        modifier = modifier.padding(bottom = Dimens.paddingSmall),
        shape = RoundedCornerShape(Dimens.cornerRadiusLarge),
        elevation = CardDefaults.cardElevation(Dimens.cardElevation1dp),
        colors = CardDefaults.cardColors(
            containerColor = if (property.isFeatured) Colors.LightGreen else Color.White, // Card background color
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
                    .size(Dimens.propertyImageSize)
                    .padding(Dimens.paddingSmall)
                    .clip(RoundedCornerShape(size = Dimens.cornerRadiusSmall)),
                imageUrl = property.imagesGallery.takeIf { it.isNotEmpty() }?.get(0)?.getImageUrl()
                    .orEmpty(),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = property.name,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )

                Spacer(modifier = Modifier.height(Dimens.paddingMedium))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier.size(Dimens.iconSizeXSmall),
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = null,
                        tint = Colors.Amber,
                    )

                    Text(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(horizontal = Dimens.paddingXSmall),
                        text = property.address1,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleSmall,
                    )
                }

                Spacer(modifier = Modifier.height(Dimens.paddingMedium))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.wrapContentWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            modifier = Modifier.size(Dimens.iconSizeXSmall),
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            tint = Colors.Amber,
                        )

                        Text(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = Dimens.paddingXSmall),
                            text = property.overallRating.convertOverallRating(),
                            maxLines = 1,
                            style = MaterialTheme.typography.labelMedium,
                        )
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = Dimens.paddingXSmall),
                        textAlign = TextAlign.End,
                        text = "${property.lowestPricePerNight.getCurrencySymbol()}${property.lowestPricePerNight.value}/" +
                                stringResource(R.string.night_text),
                        maxLines = 1,
                        color = Colors.Green,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    )
                }
            }
        }
    }
}