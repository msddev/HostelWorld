package com.mkdev.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mkdev.presentation.screen.propertyDetail.PropertyDetailScreen
import com.mkdev.presentation.screen.propertyList.PropertyListScreen
import com.mkdev.presentation.screen.splash.SplashScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainNavRoute.Splash.path
    ) {
        addSplashScreen(
            navController = navController,
            navGraphBuilder = this,
        )
        addPropertyListScreen(
            navController = navController,
            navGraphBuilder = this,
        )

        addPropertyDetailScreen(
            navController = navController,
            navGraphBuilder = this
        )
    }
}

private fun addSplashScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = MainNavRoute.Splash.path) {
        BackHandler(true) {}

        SplashScreen(
            navigateToPropertyListScreen = {
                navController.navigate(MainNavRoute.PropertyList.path)
            },
        )
    }
}

private fun addPropertyListScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = MainNavRoute.PropertyList.path) {
        BackHandler(true) {}

        PropertyListScreen(
            navigateToPropertyDetailScreen = {
                navController.navigate(MainNavRoute.PropertyDetail.path)
            },
        )
    }
}

private fun addPropertyDetailScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = MainNavRoute.PropertyDetail.path) {
        PropertyDetailScreen(
            onBackClick = { navController.popBackStack() },
        )
    }
}