package com.example.challange17

import androidx.annotation.DrawableRes

data class Food(
    val name: String,
    @DrawableRes val imageUrl: Int,
    var size : Int = 22
)
