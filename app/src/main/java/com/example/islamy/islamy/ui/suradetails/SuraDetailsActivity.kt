package com.example.islamy.islamy.ui.suradetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.databinding.ActivitySuraDetailsBinding
import com.example.islamy.islamy.ui.Constant

class SuraDetailsActivity : AppCompatActivity() {
    lateinit var suraTitle:String
    var suraPostion:Int= 1
    lateinit var binding :ActivitySuraDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        suraPostion=intent.getIntExtra(Constant.Surapostion,0)
        suraTitle=intent.getStringExtra(Constant.SuraTitle)?:""
        initView()
        readSuraFile()

    }

    private fun readSuraFile() {
        val inputStream =assets.open("$suraPostion.txt")
        val fileContent=inputStream.bufferedReader().use { it.readText() }
        val lines=fileContent.trim().split("\n")
        initRecyclerView(lines)
    }

    private fun initRecyclerView(lines: List<String>) {
       val adapter =VersesRecyclerAdapter(lines)
        binding.content.recyclerView.adapter=adapter
    }

    private fun initView() {
        binding.titleTv.text=suraTitle
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}