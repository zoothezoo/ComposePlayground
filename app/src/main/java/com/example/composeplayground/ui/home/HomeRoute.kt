package com.example.composeplayground.ui.home

import androidx.compose.runtime.Composable

/***
 * stateful
 */
@Composable
fun HomeRoute(
    navigateToUserList: () -> Unit,
    navigateToLikeAnimation: () -> Unit
) {

    // val uiState by homeViewModel.uiState.collectAsState()

    HomeRoute(
        navigateToUserList = navigateToUserList,
        navigateToLikeAnimation = navigateToLikeAnimation,
        onclick = {}
    )
}

/***
 * stateless
 */
@Composable
fun HomeRoute(
    navigateToUserList: () -> Unit,
    navigateToLikeAnimation: () -> Unit,
    onclick: () -> Unit = {}
) {
    onclick()

    HomeScreen(
        navigateToUserList = navigateToUserList,
        navigateToLikeAnimation = navigateToLikeAnimation
    )
}
