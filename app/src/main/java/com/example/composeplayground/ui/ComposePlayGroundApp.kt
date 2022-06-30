package com.example.composeplayground.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.home.HomeScreen

@Composable
fun ComposePlayGroundApp() {
    MaterialTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            ComposePlayGroundActions(navController)
        }

        navigationActions.navigateToHome

        ComposePlayGroundNavGraph(
            navController = navController,
            startDestination = ComposePlayGroundDestinations.HomeRoute.routeId
        )

        HomeScreen(
            navigateToUserList = navigationActions.navigateToUserList,
            navigateToLikeAnimation = navigationActions.navigateToLikeAnimation
        )
    }
}

@Preview
@Composable
fun ComposePlayGroundAppPreview() {
    ComposePlayGroundApp()
}
