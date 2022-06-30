package com.example.composeplayground.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.home.HomeRoute
import com.example.composeplayground.ui.likeAnimation.LikeAnimationRoute
import com.example.composeplayground.ui.userList.UserListRoute

@Composable
internal fun ComposePlayGroundNavGraph(
    // appContainer: AppContainer,
    // isExpandedScreen: Boolean,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    // openDrawer: () -> Unit = {},
    startDestination: String = ComposePlayGroundDestinations.HomeRoute.routeId
) {

    val navigationActions = remember(navController) {
        ComposePlayGroundActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ComposePlayGroundDestinations.HomeRoute.routeId) {
            HomeRoute(
                navigateToUserList = navigationActions.navigateToUserList,
                navigateToLikeAnimation = navigationActions.navigateToLikeAnimation
            )
        }

        composable(ComposePlayGroundDestinations.UserListRoute.routeId) {
            UserListRoute()
        }

        composable(ComposePlayGroundDestinations.SnackBarRoute.routeId) { /* noop */ }

        composable(ComposePlayGroundDestinations.LikeAnimationRoute.routeId) {
            LikeAnimationRoute()
        }
    }
}