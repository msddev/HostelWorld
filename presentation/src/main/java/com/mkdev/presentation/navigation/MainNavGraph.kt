package com.mkdev.presentation.navigation

import androidx.activity.ComponentActivity
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
    activity: ComponentActivity,
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
            activity = activity,
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
    activity: ComponentActivity
) {
    navGraphBuilder.composable(route = MainNavRoute.PropertyList.path) {
        BackHandler(true) {
            activity.finish()
        }

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