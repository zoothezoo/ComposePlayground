package com.example.composeplayground.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController

@Composable
fun ComposePlayGroundApp() {
    MaterialTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            ComposePlayGroundActions(navController)
        }
    }
}
