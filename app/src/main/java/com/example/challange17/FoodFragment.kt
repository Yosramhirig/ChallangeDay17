package com.example.challange17

import MySharedPref
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.challange17.databinding.FragmentFoodBinding


class FoodFragment : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    private val foodlist = mutableListOf(
        Food("Pizza", R.drawable.baseline_local_pizza_24),
        Food("Pasta", R.drawable.baseline_food_bank_24),
        Food("Burger", R.drawable.baseline_local_pizza_24),
        Food("Shawarma", R.drawable.baseline_fastfood_24),
        Food("Kebab", R.drawable.baseline_emoji_food_beverage_24),
        Food("Fish", R.drawable.baseline_local_pizza_24),
        Food("Steak", R.drawable.baseline_fastfood_24),
        Food("Fries", R.drawable.baseline_food_bank_24)
    )
    private val adapter = FoodAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)
        val pref = MySharedPref(requireContext())
        adapter.size = pref.getsize()!!
        binding.rvFood.adapter = adapter

        //submit the list
        adapter.submitList(foodlist)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}