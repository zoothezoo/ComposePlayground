package com.example.composeplayground.ui.userList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.data.User

@Composable
fun UserListScreen() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            UsersLazyColumn(User.users) { _, _ ->
                // usersを更新する必要あり？？
            }
        }
    }
}

@Composable
private fun UsersLazyColumn(
    users: List<User>,
    onChangedUserState: (user: User, position: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.apply {
            width(IntrinsicSize.Max)
            height(IntrinsicSize.Min)
        },
        contentPadding = PaddingValues(8.dp),
    ) {
        itemsIndexed(users) { position, user ->
            UserInfoRow(
                user = user,
                onClickLike = { isLiked ->
                    onChangedUserState(user.copy(isLiked = isLiked), position)
                }
            )
        }
    }
}

@Composable
private fun UserInfoRow(
    user: User,
    onClickLike: (Boolean) -> Unit
) {
    val isLiked = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(user.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .size(60.dp, 60.dp)
                .clip(CircleShape)
                .weight(1f)

        )
        Text(
            text = user.name,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .weight(1f)
        )
        Text(
            text = "${user.age}歳",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .weight(1f)
        )
        IconToggleButton(
            checked = isLiked.value,
            onCheckedChange = {
                onClickLike(it)
                isLiked.value = it
            },
            enabled = true,
            // interactionSource =,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .weight(1f)
        ) {
            Icon(
                imageVector = if (isLiked.value) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                tint = if (isLiked.value) Color.Red else Color.Gray,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserInfoRow() {
    UserListScreen()
}
