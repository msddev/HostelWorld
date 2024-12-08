package com.mkdev.presentation.screen.propertyDetail.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.CoilImage
import com.mkdev.presentation.common.components.ExpandableTextView
import com.mkdev.presentation.common.utils.textSp
import com.mkdev.presentation.mockData.mockPropertyItem
import com.mkdev.presentation.model.ImagesGalleryModel
import com.mkdev.presentation.model.PropertyModel
import com.mkdev.presentation.screen.propertyDetail.components.topAppBar.TopAppBarBackButton
import com.mkdev.presentation.screen.propertyDetail.components.topAppBar.TopAppBarTitle
import com.mkdev.presentation.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PropertyDetailContent(
    modifier: Modifier,
    property: PropertyModel,
    onBackClick: () -> Unit,
) {
    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    TopAppBarTitle(
                        title = stringResource(R.string.hostel_details),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    TopAppBarBackButton(
                        onClick = onBackClick,
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                    )
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = dimensionResource(R.dimen.padding_standard)),
            ) {
                HeaderImageView(
                    modifier = Modifier.fillMaxWidth(),
                    property = property,
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))

                PropertyNameAndLocationView(
                    modifier = Modifier.wrapContentSize(),
                    property = property,
                )

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = dimensionResource(R.dimen.padding_standard)),
                    thickness = dimensionResource(R.dimen.divider_thickness),
                    color = GrayScale200,
                )

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(R.string.photos),
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.text_size_default).textSp,
                )

                PhotosView(
                    modifier = Modifier.fillMaxWidth(),
                    images = property.imagesGallery,
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(R.string.description),
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.text_size_default).textSp,
                )

                ExpandableTextView(
                    fontSize = dimensionResource(R.dimen.text_size_small).textSp,
                    text = property.overview,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = stringResource(R.string.features),
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    fontSize = dimensionResource(R.dimen.text_size_default).textSp,
                )

                FacilitiesView(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_standard)))
            }
        }
    )
}

@Composable
private fun PhotosView(modifier: Modifier, images: List<ImagesGalleryModel>) {
    LazyRow(
        modifier = modifier,
    ) {
        items(images) { item ->
            CoilImage(
                imageUrl = item.getImageUrl(),
                modifier = Modifier
                    .size(110.dp)
                    .padding(dimensionResource(R.dimen.padding_2x_small))
                    .clip(
                        RoundedCornerShape(
                            size = dimensionResource(id = R.dimen.corner_radius_small)
                        )
                    ),
                contentScale = ContentScale.FillWidth,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FacilitiesView(modifier: Modifier) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        ChipItemView(
            text = stringResource(R.string.facility_wi_fi),
            icon = painterResource(id = R.drawable.ic_wi_fi),
        )
        ChipItemView(
            text = stringResource(R.string.facility_swimming_pool),
            icon = painterResource(id = R.drawable.ic_swimming_pool),
        )
        ChipItemView(
            text = stringResource(R.string.facility_restaurant),
            icon = painterResource(id = R.drawable.ic_restaurant),
        )
        ChipItemView(
            text = stringResource(R.string.facility_parking),
            icon = painterResource(id = R.drawable.ic_parking),
        )
        ChipItemView(
            text = stringResource(R.string.facility_bathroom),
            icon = painterResource(id = R.drawable.ic_bedroom),
        )
        ChipItemView(
            text = stringResource(R.string.facility_elevator),
            icon = painterResource(id = R.drawable.ic_elevator),
        )
        ChipItemView(
            text = stringResource(R.string.facility_fitness_center),
            icon = painterResource(id = R.drawable.ic_fitness_center),
        )
    }
}

@Composable
private fun PropertyNameAndLocationView(modifier: Modifier, property: PropertyModel) {
    Text(
        modifier = modifier,
        text = property.name,
        maxLines = 1,
        fontWeight = FontWeight.Bold,
        fontSize = dimensionResource(R.dimen.text_size_large).textSp,
    )

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_small)),
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            tint = Amber,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_small)),
            text = "Location",
            maxLines = 1,
            fontSize = dimensionResource(R.dimen.text_size_medium).textSp,
            color = GrayScale700
        )
    }
}

@Composable
private fun HeaderImageView(modifier: Modifier, property: PropertyModel) {
    CoilImage(
        imageUrl = property.imagesGallery.takeIf { it.isNotEmpty() }?.get(0)
            ?.getImageUrl()
            .orEmpty(),
        modifier = modifier
            .clip(RoundedCornerShape(size = dimensionResource(id = R.dimen.corner_radius_small))),
        contentScale = ContentScale.None
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ScreenPreview() {
    MaterialTheme {
        PropertyDetailContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_x_small)),
            property = mockPropertyItem,
            onBackClick = {

            }
        )
    }
}