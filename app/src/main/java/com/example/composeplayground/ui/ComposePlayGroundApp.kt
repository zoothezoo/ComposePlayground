package com.example.composeplayground.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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

        HomeScreen(
            navigateToUserList = navigationActions.navigateToUserList
        )
    }
}
