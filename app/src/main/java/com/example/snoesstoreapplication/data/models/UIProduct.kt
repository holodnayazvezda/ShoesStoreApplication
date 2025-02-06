package com.example.snoesstoreapplication.data.models

import com.example.snoesstoreapplication.R
import kotlinx.serialization.Serializable

@Serializable
data class UIProduct(
    val isLiked: Boolean = true,
    val image: Int = R.drawable.airmax,
    val title: String = "BEST SELLER",
    val name: String = "Nike Air Max",
    var price: String = "752.00"
)

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Float,
    val image: String,
    val category: String
)


val UIProducts = listOf(
    UIProduct(), UIProduct(), UIProduct(), UIProduct(),
    UIProduct(), UIProduct(), UIProduct(), UIProduct(),
    UIProduct(), UIProduct(), UIProduct(), UIProduct(),
    UIProduct(), UIProduct(), UIProduct(), UIProduct(),
    UIProduct(), UIProduct(), UIProduct(), UIProduct(),
)