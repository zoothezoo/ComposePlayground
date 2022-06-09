package com.example.composeplayground.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ui.home.HomeRoute
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
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ComposePlayGroundDestinations.HomeRoute.routeId) {
            HomeRoute()
        }
        composable(ComposePlayGroundDestinations.UserListRoute.routeId) {
            UserListRoute()
        }
        composable(ComposePlayGroundDestinations.SnackBarRoute.routeId) {
            UserListRoute()
        }
    }
}