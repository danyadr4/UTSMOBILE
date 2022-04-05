package com.example.dogglers.model

import androidx.annotation.DrawableRes

data class Laptop(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val brand: String,
    val price: String
)
