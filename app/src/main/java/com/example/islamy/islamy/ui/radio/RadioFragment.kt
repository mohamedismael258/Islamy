package com.example.islamy.islamy.ui.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentQuranBinding
import com.example.islamy.databinding.FragmentRadioBinding

class RadioFragment: Fragment() {
    lateinit var binding: FragmentRadioBinding
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRadioBinding.inflate(layoutInflater)
        return binding.root
    }
}