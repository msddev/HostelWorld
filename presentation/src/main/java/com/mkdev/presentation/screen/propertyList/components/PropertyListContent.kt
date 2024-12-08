package com.mkdev.presentation.screen.propertyList.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.mockData.mockPropertyItem
import com.mkdev.presentation.mockData.mockPropertyList
import com.mkdev.presentation.model.PropertyModel

@Composable
internal fun PropertyListContent(
    modifier: Modifier,
    featuredProperties: List<PropertyModel>,
    normalProperties: List<PropertyModel>,
    onItemClick: () -> Unit,
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
                item {
                    Text(
                        modifier=Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp),
                        text = "Featured Properties"
                    )
                }
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(8.dp)
                    ) {
                        items(featuredProperties) { item ->
                            PropertyFeaturedItem(
                                modifier = Modifier
                                    .width(180.dp)
                                    .padding(end = 8.dp),
                                property = mockPropertyItem,
                                onItemClick = {

                                },
                            )
                        }
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_x_small)))
                }

                items(normalProperties) { item ->
                    PropertyNormalItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        property = mockPropertyItem,
                        onItemClick = {

                        },
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ScreenPreview() {
    MaterialTheme {
        PropertyListContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_x_small)),
            featuredProperties = mockPropertyList,
            normalProperties = mockPropertyList,
            onItemClick = {

            },
        )
    }
}