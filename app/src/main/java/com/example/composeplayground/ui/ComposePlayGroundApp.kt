package com.example.composeplayground.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController

@Composable
fun ComposePlayGroundApp() {
    val navController = rememberNavController()
    ComposePlayGroundNavGraph(
        navController = navController,
        startDestination = ComposePlayGroundDestinations.HomeRoute.routeId
    )
}
