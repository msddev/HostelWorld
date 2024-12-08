package com.mkdev.presentation.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.util.DebugLogger
import com.mkdev.presentation.R
import com.mkdev.presentation.theme.HostelWorldTheme

@Composable
fun CoilImage(
    modifier: Modifier,
    imageUrl: String,
    contentScale: ContentScale,
) {
    Image(
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .placeholder(R.drawable.img_place_holder)
                .error(R.drawable.img_place_holder)
                .crossfade(true)
                .memoryCacheKey(imageUrl)
                .diskCacheKey(imageUrl)
                .build(),
            imageLoader = ImageLoader.Builder(LocalContext.current)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .logger(DebugLogger())
                .build()
        ),
        contentDescription = null,
        modifier = modifier,
        contentScale = contentScale,
    )
}

@Preview(showBackground = true)
@Composable
private fun ScreenPreview() {
    HostelWorldTheme {
        CoilImage(
            imageUrl = "https://www.test.com",
            modifier = Modifier.size(width = 100.dp, height = 130.dp),
            contentScale = ContentScale.Companion.FillHeight,
        )
    }
}