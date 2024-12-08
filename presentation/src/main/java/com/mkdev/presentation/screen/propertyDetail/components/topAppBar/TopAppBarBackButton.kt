package com.mkdev.presentation.screen.propertyDetail.components.topAppBar

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun TopAppBarBackButton(onClick: () -> Unit, icon: ImageVector) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
    }
}