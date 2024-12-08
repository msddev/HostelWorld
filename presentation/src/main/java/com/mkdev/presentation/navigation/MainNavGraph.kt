package com.mkdev.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mkdev.presentation.screen.propertyDetail.PropertyDetailScreen
import com.mkdev.presentation.screen.propertyList.PropertyListScreen

@Composable
fun MainNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MainNavRoute.PropertyDetail.path
    ) {
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

private fun addPropertyListScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
) {
    navGraphBuilder.composable(route = MainNavRoute.PropertyList.path) {

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