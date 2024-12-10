package com.mkdev.presentation.screen.propertyDetail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.ExpandableTextView
import com.mkdev.presentation.common.components.GlideImageLoader
import com.mkdev.presentation.common.utils.textSp
import com.mkdev.presentation.model.property.FacilityListModel
import com.mkdev.presentation.model.property.ImagesGalleryModel
import com.mkdev.presentation.model.property.PricePerNightModel
import com.mkdev.presentation.model.property.PropertyModel
import com.mkdev.presentation.screen.propertyDetail.components.topAppBar.TopAppBarBackButton
import com.mkdev.presentation.screen.propertyDetail.components.topAppBar.TopAppBarTitle
import com.mkdev.presentation.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PropertyDetailContent(
    modifier: Modifier,
    property: PropertyModel,
    onCurrencyFilterClick: () -> Unit,
    onBackClick: () -> Unit,
    onReservedClick: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                ),
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
                },
                actions = {
                    IconButton(onClick = onCurrencyFilterClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_filter_border),
                            tint = Color.Black,
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        content = { padding ->
            Box(modifier = Modifier.fillMaxSize()) {
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

                    FacilitiesView(
                        modifier = Modifier.fillMaxWidth(),
                        facilities = property.facilities
                    )

                    Spacer(modifier = Modifier.height(120.dp))
                }

                ReservedSection(
                    lowestPricePerNight = property.lowestPricePerNight,
                    onReservedClick = onReservedClick
                )
            }
        }
    )
}

@Composable
private fun BoxScope.ReservedSection(
    lowestPricePerNight: PricePerNightModel,
    onReservedClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
            .padding(dimensionResource(R.dimen.padding_small))
            .background(
                Color.Black,
                shape = RoundedCornerShape(dimensionResource(R.dimen.corner_radius_x_large))
            )
            .padding(horizontal = dimensionResource(R.dimen.padding_small)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(R.string.price),
                maxLines = 1,
                color = Color.White,
                fontSize = dimensionResource(R.dimen.text_size_small).textSp,
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "${lowestPricePerNight.getCurrencySymbol()}${lowestPricePerNight.value}/night",
                maxLines = 1,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(R.dimen.text_size_default).textSp,
            )
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.corner_radius_x_large)))
                .padding(dimensionResource(R.dimen.padding_small)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            onClick = onReservedClick,
        ) {
            Text(
                text = stringResource(R.string.reserve_now),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
private fun PhotosView(modifier: Modifier, images: List<ImagesGalleryModel>) {
    LazyRow(
        modifier = modifier,
    ) {
        items(images) { item ->
            GlideImageLoader(
                imageUrl = item.getImageUrl(),
                modifier = Modifier
                    .size(110.dp)
                    .padding(dimensionResource(R.dimen.padding_2x_small))
                    .clip(
                        RoundedCornerShape(
                            size = dimensionResource(id = R.dimen.corner_radius_small)
                        )
                    ),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FacilitiesView(modifier: Modifier, facilities: List<FacilityListModel>) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_2x_small)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_2x_small))
    ) {

        facilities.forEach { category ->
            category.facilities.forEach { facility ->
                ChipItemView(
                    text = facility.name,
                )
            }
        }
    }
}

@Composable
private fun ColumnScope.PropertyNameAndLocationView(modifier: Modifier, property: PropertyModel) {
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
            text = property.address1,
            maxLines = 1,
            fontSize = dimensionResource(R.dimen.text_size_medium).textSp,
            color = GrayScale700
        )
    }

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(dimensionResource(R.dimen.icon_size_small)),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = Amber,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.padding_small)),
            text = "${property.overallRating.convertOverallRating()} (${property.overallRating.numberOfRatings} reviews)",
            maxLines = 1,
            fontSize = dimensionResource(R.dimen.text_size_medium).textSp,
            color = GrayScale700
        )
    }
}

@Composable
private fun HeaderImageView(modifier: Modifier, property: PropertyModel) {
    GlideImageLoader(
        modifier = modifier
            .clip(RoundedCornerShape(size = dimensionResource(id = R.dimen.corner_radius_small))),
        imageUrl = property.imagesGallery.takeIf { it.isNotEmpty() }?.get(0)
            ?.getImageUrl()
            .orEmpty(),
        contentScale = ContentScale.FillWidth
    )
}