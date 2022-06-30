package com.example.composeplayground.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composeplayground.ui.ComposePlayGroundDestinations

@Composable
internal fun HomeScreen(
    navigateToUserList: () -> Unit,
    navigateToLikeAnimation: () -> Unit,
) {
    LazyColumn {
        items(Directions.directions) { direction ->
            ScreenTitleItem(
                direction = direction,
                onClickRow = { destination ->
                    when (destination) {
                        ComposePlayGroundDestinations.UserListRoute -> navigateToUserList()
                        ComposePlayGroundDestinations.LikeAnimationRoute -> navigateToLikeAnimation()
                        ComposePlayGroundDestinations.HomeRoute,
                        ComposePlayGroundDestinations.SnackBarRoute -> { /* no-op */
                        }
                    }
                }
            )
        }
    }
}

@Composable
internal fun ScreenTitleItem(
    direction: ComposePlayGroundDestinations,
    onClickRow: (ComposePlayGroundDestinations) -> Unit
) {
    Row(
        modifier = Modifier.padding(16.dp)

    ) {
        Text(
            text = direction.screenTitle,
            modifier = Modifier.clickable { onClickRow(direction) }
        )
    }
}

internal object Directions {
    val directions = listOf(
        ComposePlayGroundDestinations.UserListRoute,
        ComposePlayGroundDestinations.SnackBarRoute,
        ComposePlayGroundDestinations.LikeAnimationRoute
    )
}
