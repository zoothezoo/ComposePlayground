package com.example.composeplayground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeplayground.data.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Text(text = "hello, world")
                    UsersLazyColumn(User.users)
                }
            }
        }
    }
}

@Composable
private fun UsersLazyColumn(users: List<User>) {
    LazyColumn(
        modifier = Modifier.apply {
            width(IntrinsicSize.Max)
            height(IntrinsicSize.Min)
        },
        contentPadding = PaddingValues(8.dp),
    ) {
        items(users) { user ->
            UserInfoRow(user = user)
        }
    }
}

@Composable
private fun UserInfoRow(user: User) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(user.image),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )
        Text(
            text = user.name,
            fontSize = 24.sp,
            modifier = Modifier
                .size(width = 100.dp, height = 100.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Text(
            text = "${user.age}歳",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun PreviewUserInfoRow() {
    UserInfoRow(User.users[0])
}
