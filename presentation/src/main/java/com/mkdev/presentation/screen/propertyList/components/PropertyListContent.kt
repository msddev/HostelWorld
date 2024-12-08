package com.mkdev.presentation.screen.propertyList.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.mockData.mockPropertyList
import com.mkdev.presentation.model.PropertyModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PropertyListContent(
    modifier: Modifier,
    featuredProperties: List<PropertyModel>,
    normalProperties: List<PropertyModel>,
    onItemClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding(),
        topBar = {
            SearchBarView(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_x_small)),
            )
        },
        content = { padding ->
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                item {
                    Text(text = "Featured Properties")
                }
                item {
                    LazyRow(
                        Modifier
                            .fillMaxSize(),
                        contentPadding = PaddingValues(bottom = 16.dp)
                    ) {
                        items(featuredProperties) { item ->
                            FeaturedPropertyItem(item)
                        }
                    }
                }
                items(featuredProperties) { item ->
                    NormalPropertyItem(item)
                }
            }
        }
    )
}

@Composable
private fun FeaturedPropertyItem(property: PropertyModel) {
    Box(
        modifier = Modifier
            .size(160.dp)
            .padding(8.dp)
            .background(color = Color.Green)
    )
}

@Composable
private fun NormalPropertyItem(property: PropertyModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(8.dp)
            .background(color = Color.Blue)
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