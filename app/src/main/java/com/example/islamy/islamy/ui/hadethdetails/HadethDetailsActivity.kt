package com.example.islamy.islamy.ui.hadethdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHadethDetailsBinding
import com.example.islamy.islamy.ui.Constant

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding :ActivityHadethDetailsBinding
     lateinit var hadethContent:String
    lateinit var hadethTitle:String
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityHadethDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
         hadethTitle = intent.getStringExtra(Constant.hadethTitile)?:""
         hadethContent=intent.getStringExtra(Constant.hadethConten)?:""
         setHadeth(hadethTitle,hadethContent)
        initView()

    }
    private fun setHadeth(hadethTitle: String, hadethContent: String) {
        binding.content.hadethContetn.text=hadethContent
    }
    private fun initView() {
        binding.titleTv.text=hadethTitle
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}