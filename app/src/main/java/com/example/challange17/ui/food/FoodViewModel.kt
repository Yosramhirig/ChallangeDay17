package com.example.challange17.ui.food

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challange17.model.FoodRepository
import com.example.challange17.model.FoodRepositoryImpl


class FoodViewModel: ViewModel() {

    private var _foodList: MutableLiveData<List<Food>> = MutableLiveData(emptyList())
    val foodList: LiveData<List<Food>> get() = _foodList
    private val repository: FoodRepository = FoodRepositoryImpl()

    init {
        getListOfFood()
    }

    fun getListOfFood(){
        _foodList.value = repository.getFoodList()
    }


}