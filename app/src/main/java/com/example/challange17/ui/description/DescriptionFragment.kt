package com.example.challange17.ui.description

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.challange17.R
import com.example.challange17.databinding.FragmentDescriptionBinding
import com.example.challange17.databinding.FragmentFoodBinding
import com.example.challange17.model.FoodRepositoryImpl
import com.example.challange17.model.MySharedPref


class DescriptionFragment : Fragment(R.layout.fragment_description) {
    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDescriptionBinding.bind(view)
         val pref = MySharedPref(requireContext())
        val img = FoodRepositoryImpl().getFoodList()
        var position : Int = 0
          position =  pref.getpsition()
        binding.imageView.load(img[position].imageUrl)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}