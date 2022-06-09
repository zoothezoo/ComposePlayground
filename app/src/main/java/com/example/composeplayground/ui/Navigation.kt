package com.example.composeplayground.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object ComposePlayGroundDestinations {
    const val HOME_ROUTE = "home"
    const val USER_LIST_ROUTE = "user_list"
    const val SNACK_BAR_ROUTE = "snack_bar"
}

internal class ComposePlayGroundActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToUserList: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.USER_LIST_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }

    val navigateToSnackBar: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.SNACK_BAR_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }
}
