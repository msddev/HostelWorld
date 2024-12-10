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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.common.components.ExpandableTextView
import com.mkdev.presentation.common.components.GlideImageLoader
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
                        .padding(horizontal = Dimens.paddingStandard),
                ) {
                    HeaderImageView(
                        modifier = Modifier.fillMaxWidth(),
                        property = property,
                    )

                    Spacer(modifier = Modifier.height(Dimens.paddingStandard))

                    PropertyNameAndLocationView(
                        modifier = Modifier.wrapContentSize(),
                        property = property,
                    )

                    HorizontalDivider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = Dimens.paddingStandard),
                        thickness = Dimens.dividerThickness,
                        color = Colors.GrayScale200,
                    )

                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = stringResource(R.string.photos),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    )

                    Spacer(modifier = Modifier.height(Dimens.padding2xSmall))

                    PhotosView(
                        modifier = Modifier.fillMaxWidth(),
                        images = property.imagesGallery,
                    )

                    Spacer(modifier = Modifier.height(Dimens.paddingStandard))

                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = stringResource(R.string.description),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    )

                    Spacer(modifier = Modifier.height(Dimens.padding2xSmall))

                    ExpandableTextView(
                        fontSize = Dimens.textSizeMedium,
                        text = property.overview,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(Dimens.paddingStandard))

                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = stringResource(R.string.features),
                        maxLines = 1,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    )

                    Spacer(modifier = Modifier.height(Dimens.padding2xSmall))

                    FacilitiesView(
                        modifier = Modifier.fillMaxWidth(),
                        facilities = property.facilities
                    )

                    Spacer(modifier = Modifier.height(Dimens.propertyDetailEndOfListSpace))
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
            .padding(Dimens.paddingSmall)
            .background(
                Color.Black,
                shape = RoundedCornerShape(Dimens.cornerRadiusXLarge)
            )
            .padding(horizontal = Dimens.paddingXSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = stringResource(R.string.price),
                maxLines = 1,
                color = Color.White,
                fontSize = Dimens.textSizeSmall,
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = "${lowestPricePerNight.getCurrencySymbol()}${lowestPricePerNight.value}/" +
                        stringResource(R.string.night_text),
                maxLines = 1,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            )
        }

        Button(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(Dimens.cornerRadiusXLarge))
                .padding(Dimens.paddingSmall),
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
                    .padding(Dimens.padding2xSmall)
                    .clip(
                        RoundedCornerShape(
                            size = Dimens.cornerRadiusSmall
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
        horizontalArrangement = Arrangement.spacedBy(Dimens.padding2xSmall),
        verticalArrangement = Arrangement.spacedBy(Dimens.padding2xSmall)
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
        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
    )

    Spacer(modifier = Modifier.height(Dimens.paddingSmall))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(Dimens.iconSizeSmall),
            painter = painterResource(id = R.drawable.ic_location),
            contentDescription = null,
            tint = Colors.Amber,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.paddingSmall),
            text = property.address1,
            maxLines = 1,
            color = Colors.GrayScale700,
            style = MaterialTheme.typography.titleSmall,
        )
    }

    Spacer(modifier = Modifier.height(Dimens.paddingSmall))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(Dimens.iconSizeSmall),
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = Colors.Amber,
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.paddingSmall),
            text = "${property.overallRating.convertOverallRating()} (${property.overallRating.numberOfRatings} reviews)",
            maxLines = 1,
            style = MaterialTheme.typography.titleSmall,
            color = Colors.GrayScale700
        )
    }
}

@Composable
private fun HeaderImageView(modifier: Modifier, property: PropertyModel) {
    GlideImageLoader(
        modifier = modifier
            .clip(RoundedCornerShape(size = Dimens.cornerRadiusSmall)),
        imageUrl = property.imagesGallery.takeIf { it.isNotEmpty() }?.get(0)
            ?.getImageUrl()
            .orEmpty(),
        contentScale = ContentScale.FillWidth
    )
}