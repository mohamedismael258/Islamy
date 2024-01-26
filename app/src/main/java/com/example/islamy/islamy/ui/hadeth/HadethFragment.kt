package com.example.islamy.islamy.ui.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.islamy.ui.Constant
import com.example.islamy.islamy.ui.hadethdetails.HadethDetailsActivity
import com.example.islamy.islamy.ui.model.Hadeth

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
        readHadethFile()
    }
lateinit var adapter:HadethRecyclerAdapter
    private fun startHadeth(hadethTitle:String,hadethContent: String,) {
        val intent = Intent(activity, HadethDetailsActivity::class.java)

        intent.putExtra(Constant.hadethTitile,hadethTitle)
        intent.putExtra(Constant.hadethConten,hadethContent)
        startActivity(intent)
    }
    fun readHadethFile()
    {
        val hadethList= mutableListOf<Hadeth>()
        val inputStream =context?.assets?.open("ahadeeth.txt")
        val fileContent=inputStream?.bufferedReader().use { it?.readText() }
        val allAhadeth=fileContent?.trim()?.split("#")
        allAhadeth?.forEach{hadeth->
            val lines =hadeth.trim().split("\n")
            val title=lines[0]
            val newList=lines.toMutableList().apply {
                removeAt(0)
            }
            val content= newList.joinToString ("\n")
           val hadeth= Hadeth(title,content)
            hadethList.add(hadeth)
        }
        showHadethContent(hadethList)
    }

    private fun showHadethContent(hadethList: MutableList<Hadeth>) {
        adapter = HadethRecyclerAdapter(hadethList)
        adapter.onItemClickListner = HadethRecyclerAdapter.OnItemClickListner{item,postion ->
            startHadeth(hadethList[postion].title,hadethList[postion].content)
        }
        binding.recyclerHadeth.adapter=adapter
    }
}