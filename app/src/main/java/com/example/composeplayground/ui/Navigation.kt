package com.example.composeplayground.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

internal sealed interface ComposePlayGroundDestinations {
    val routeId: String
    val screenTitle: String

    object HomeRoute : ComposePlayGroundDestinations {
        override val routeId = "home"
        override val screenTitle = "ホーム画面"
    }

    object UserListRoute : ComposePlayGroundDestinations {
        override val routeId = "user_list"
        override val screenTitle = "ユーザリスト画面"
    }

    object SnackBarRoute : ComposePlayGroundDestinations {
        override val routeId = "snack_bar"
        override val screenTitle = "スナックバー画面"
    }

    object LikeAnimationRoute : ComposePlayGroundDestinations {
        override val routeId = "like_animatoin"
        override val screenTitle = "いいねアニメーション画面"
    }
}

internal class ComposePlayGroundActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.HomeRoute.routeId) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            // launchSingleTop = true
            // restoreState = true
        }
    }

    val navigateToUserList: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.UserListRoute.routeId) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
/*
            launchSingleTop = true
            restoreState = true
*/
        }
    }

    val navigateToSnackBar: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.SnackBarRoute.routeId) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToLikeAnimation: () -> Unit = {
        navController.navigate(ComposePlayGroundDestinations.LikeAnimationRoute.routeId) {
            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
/*
            launchSingleTop = true
            restoreState = true
*/
        }
    }
}
