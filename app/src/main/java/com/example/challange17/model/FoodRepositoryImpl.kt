package com.example.challange17.model

import com.example.challange17.R
import com.example.challange17.ui.food.Food


class FoodRepositoryImpl:FoodRepository {

    private val foods = mutableListOf(
        Food("Pizza", R.drawable.baseline_local_pizza_24),
        Food("Pasta", R.drawable.baseline_food_bank_24),
        Food("Burger", R.drawable.baseline_local_pizza_24),
        Food("Shawarma", R.drawable.baseline_fastfood_24),
        Food("Kebab", R.drawable.baseline_emoji_food_beverage_24),
        Food("Fish", R.drawable.baseline_local_pizza_24),
        Food("Steak", R.drawable.baseline_fastfood_24),
        Food("Fries", R.drawable.baseline_food_bank_24)
    )

    override fun getFoodList(): List<Food> {
        return foods
    }




}