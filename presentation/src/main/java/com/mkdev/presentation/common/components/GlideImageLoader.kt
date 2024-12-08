package com.mkdev.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkdev.presentation.R
import com.mkdev.presentation.theme.HostelWorldTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GlideImageLoader(
    modifier: Modifier,
    imageUrl: String,
    contentScale: ContentScale,
) {

    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(
            contentScale = contentScale,
        ),
        previewPlaceholder = painterResource(R.drawable.img_place_holder),
        failure = {
            PlaceHolderImage(
                modifier = modifier,
                contentScale = contentScale,
            )
        },
        loading = {
            PlaceHolderImage(
                modifier = modifier,
                contentScale = contentScale,
            )
        }
    )
}

@Composable
private fun PlaceHolderImage(
    modifier: Modifier,
    contentScale: ContentScale,
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.img_place_holder),
        contentScale = contentScale,
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
private fun ScreenPreview() {
    HostelWorldTheme {
        GlideImageLoader(
            imageUrl = "https://www.test.com",
            modifier = Modifier.size(width = 100.dp, height = 130.dp),
            contentScale = ContentScale.Companion.FillHeight,
        )
    }
}