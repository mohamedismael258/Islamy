package com.example.islamy.islamy.ui.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemHadethBinding
import com.example.islamy.databinding.ItemSuraBinding

class HadethRecyclerAdapter(private val hadethList: List<String>): RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    lateinit var itemBinding: ItemHadethBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding=ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
      return 50
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val title=hadethList[0]
        holder.bind(title,position)
    }
    class ViewHolder(val itemBinding: ItemHadethBinding): RecyclerView.ViewHolder(itemBinding.root) {
      fun bind(title:String,position: Int)
      {
          itemBinding.hadethName.setText(title)
          itemBinding.hadethName.append(" "+(position+1))
      }
    }
}