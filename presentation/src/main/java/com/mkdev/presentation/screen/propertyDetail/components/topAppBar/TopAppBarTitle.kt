package com.mkdev.presentation.screen.propertyDetail.components.topAppBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.mkdev.presentation.R
import com.mkdev.presentation.common.utils.textSp

@Composable
fun TopAppBarTitle(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    title: String,
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = title,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        fontSize = dimensionResource(id = R.dimen.text_size_large).textSp,
        textAlign = textAlign,
    )
}