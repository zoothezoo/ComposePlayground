package com.example.composeplayground

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.android.material.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                UserInfoRow(user = User.users[0])
            }
        }
    }
}

@Composable
private fun UserInfoRow(user: User) {
    ConstraintLayout {
        val (textName, textAge, imageUser) = createRefs()
        Image(
            painter = painterResource(user.image),
            contentDescription = null,
            modifier = Modifier.constrainAs(imageUser) {
                top.linkTo(anchor = parent.top, margin = 16.dp)
                start.linkTo(anchor = parent.start, margin = 16.dp)
                bottom.linkTo(anchor = parent.bottom, margin = 16.dp)
            }
        )

        Text(
            text = user.name,
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(textName) {
                top.linkTo(anchor = parent.top, margin = 16.dp)
                start.linkTo(anchor = imageUser.end, margin = 8.dp)
                bottom.linkTo(anchor = parent.bottom, margin = 16.dp)
            }

        )

        Text(
            text = "${user.age}歳",
            fontSize = 24.sp,
            modifier = Modifier.constrainAs(textAge) {
                top.linkTo(anchor = parent.top, margin = 16.dp)
                start.linkTo(anchor = textName.end, margin = 8.dp)
                bottom.linkTo(anchor = parent.bottom, margin = 16.dp)
            }
        )
    }
}

@Preview
@Composable
fun PreviewUserInfoRow() {
    UserInfoRow(user = User.users[0])
}

data class User(
    val name: String,
    val age: Int,
    @DrawableRes val image: Int,
    val isLiked: Boolean
) {
    companion object {
        val users = listOf<User>(
            User(
                name = "taro",
                age = 21,
                image = R.drawable.ic_clock_black_24dp,
                isLiked = true
            ),
            User(
                name = "jiro",
                age = 22,
                image = R.drawable.ic_clock_black_24dp,
                isLiked = true
            ),
        )
    }
}
