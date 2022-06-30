package com.example.composeplayground.data

import androidx.annotation.DrawableRes
import com.example.composeplayground.R

data class User(
    val name: String,
    val age: Int,
    @DrawableRes val image: Int,
    val isLiked: Boolean
) {
    companion object {
        val users = listOf(
            User(
                name = "taro",
                age = 21,
                image = R.drawable.emma,
                isLiked = true
            ),
            User(
                name = "jiro",
                age = 22,
                image = R.drawable.emma,
                isLiked = true
            ),
            User(
                name = "saburo",
                age = 22,
                image = R.drawable.emma,
                isLiked = true
            ),
            User(
                name = "shiro",
                age = 22,
                image = R.drawable.emma,
                isLiked = true
            )
        )
    }
}
