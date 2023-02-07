package com.example.challange17.ui.settings

import com.example.challange17.model.MySharedPref
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.challange17.R

import com.example.challange17.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingsBinding.bind(view)

        val pref = MySharedPref(requireContext())
        binding.apply {
            if(pref.getsize() != null){
                binding.rbLarge.setOnClickListener(){
                    pref.savesize(40f)
                    textView.textSize = pref.getsize()!!
                }
                binding.rbMeduim.setOnClickListener(){
                    pref.savesize(35f)
                    textView.textSize = pref.getsize()!!
                }
                binding.rbSmall.setOnClickListener(){
                    pref.savesize(15f)
                    textView.textSize = pref.getsize()!!
                }
            }else{
                pref.savesize(40f)
                textView.textSize = pref.getsize()!!

            }


        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}