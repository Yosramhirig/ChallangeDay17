package com.example.challange17.model

import com.example.challange17.ui.food.Food


interface FoodRepository {

    fun getFoodList(): List<Food>


}