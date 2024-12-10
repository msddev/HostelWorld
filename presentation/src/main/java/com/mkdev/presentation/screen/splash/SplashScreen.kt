package com.mkdev.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mkdev.presentation.R
import com.mkdev.presentation.theme.Dimens
import kotlinx.coroutines.delay

@Composable
internal fun SplashScreen(
    navigateToPropertyListScreen: () -> Unit
) {
    LaunchedEffect(Unit) {
        delay(2000)
        navigateToPropertyListScreen()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                painter = painterResource(id = R.drawable.img_top),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.paddingSmall)
                    .align(Alignment.CenterStart),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.paddingSmall),
                    text = stringResource(R.string.good_day),
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = Dimens.paddingSmall),
                    text = stringResource(R.string.find_the_best_place_to_stay_for_you),
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                )
            }

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                painter = painterResource(id = R.drawable.img_main),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )
        }
    }
}