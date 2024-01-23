package com.example.islamy.islamy.ui.hadeth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.databinding.FragmentQuranBinding
import com.example.islamy.islamy.ui.quran.SuraRecyclerAdapter

class HadethFragment: Fragment() {
    lateinit var binding: FragmentHadethBinding
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHadethBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initiateRecyclerView()
    }
lateinit var adapter:HadethRecyclerAdapter
    private val hadethName= listOf<String>("الحديث رقم")
    private fun initiateRecyclerView() {
        adapter = HadethRecyclerAdapter(hadethName)
        binding.recyclerHadeth.adapter=adapter
    }
}