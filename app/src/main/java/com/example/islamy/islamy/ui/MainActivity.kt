package com.example.islamy.islamy.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.islamy.R
import com.example.islamy.databinding.ActivityMainBinding
import com.example.islamy.islamy.ui.hadeth.HadethFragment
import com.example.islamy.islamy.ui.quran.QuranFragment
import com.example.islamy.islamy.ui.radio.RadioFragment
import com.example.islamy.islamy.ui.tasbeh.TasbehFragment
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarView

class MainActivity() : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
        override fun onCreate(savedInstanceState: Bundle?) {
    binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initatActivity()
    }

    private fun initatActivity() {
        binding.content.buttonNav.setOnItemSelectedListener { item ->
           val fragment:Fragment= when (item.itemId) {
                R.id.quran -> {
            QuranFragment()
                }
                R.id.hadeth -> {
                    HadethFragment()
                }

                R.id.radio -> {
                    RadioFragment()
                }

                R.id.sebha -> {
                    TasbehFragment()
                }

               else -> {
                   QuranFragment()
               }
           }
            pushFragment(fragment)
            true
        }
        binding.content.buttonNav.selectedItemId=R.id.quran
    }
    fun pushFragment(fragment :Fragment)
    {
    supportFragmentManager.beginTransaction().replace(R.id.fragment_contanier,fragment).commit()
    }
}