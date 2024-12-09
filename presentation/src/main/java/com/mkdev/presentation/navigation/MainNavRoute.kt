package com.mkdev.presentation.navigation

sealed class MainNavRoute(val path: String) {
    data object Splash : MainNavRoute("splash")
    data object PropertyList : MainNavRoute("property_list")
    data object PropertyDetail : MainNavRoute("property_detail")
}