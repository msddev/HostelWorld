package com.mkdev.presentation.screen.propertyList.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mkdev.presentation.R
import com.mkdev.presentation.model.property.PropertyModel

@Composable
internal fun PropertyListContent(
    modifier: Modifier,
    featuredProperties: List<PropertyModel>,
    normalProperties: List<PropertyModel>,
    onItemClick: (selectedProperty: PropertyModel) -> Unit,
) {
    Scaffold(
        modifier = modifier.statusBarsPadding(),
        topBar = {
            SearchBarView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_x_small)),
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
            ) {
                if (featuredProperties.isNotEmpty()) {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(dimensionResource(R.dimen.padding_small)),
                            text = stringResource(R.string.featured_properties)
                        )
                    }
                    items(featuredProperties) { property ->
                        PropertyItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = dimensionResource(R.dimen.padding_small)),
                            property = property,
                            onItemClick = {
                                onItemClick.invoke(property)
                            },
                        )
                    }
                }

                items(normalProperties) { property ->
                    PropertyItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = dimensionResource(R.dimen.padding_small)),
                        property = property,
                        onItemClick = {
                            onItemClick.invoke(property)
                        },
                    )
                }
            }
        }
    )
}