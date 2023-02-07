package com.example.challange17.ui.food

import com.example.challange17.model.MySharedPref
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.challange17.R
import com.example.challange17.databinding.FragmentFoodBinding


class FoodFragment : Fragment(R.layout.fragment_food) {
    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<FoodViewModel>()
    var adapter = FoodAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)
        val pref = MySharedPref(requireContext())

        adapter.size = pref.getsize()!!

        binding.apply   {
            rvFood.adapter = adapter
        }
        viewModel.foodList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }

        adapter.onItemClickListener(object : FoodAdapter.onclickListener{
            override fun onItemClick(position: Int) {
                pref.savpositin(position)
               val action = FoodFragmentDirections.actionFoodFragmentToDescriptionFragment()
                view.findNavController().navigate(action)
            }

        })

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}