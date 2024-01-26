package com.example.islamy.islamy.ui.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemHadethBinding
import com.example.islamy.databinding.ItemSuraBinding
import com.example.islamy.islamy.ui.model.Hadeth
import com.example.islamy.islamy.ui.quran.SuraRecyclerAdapter

class HadethRecyclerAdapter(private val hadethList: MutableList<Hadeth>): RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {

    lateinit var itemBinding: ItemHadethBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding=ItemHadethBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
      return 50
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val title=hadethList[position].title
        holder.bind(title)
        onItemClickListner?.let { listner->
            holder.itemBinding.hadethName.setOnClickListener() {
                    listner.onItemClick(title, position)
                 }
        }  }
    var onItemClickListner: HadethRecyclerAdapter.OnItemClickListner?=null
    fun interface OnItemClickListner{
        fun onItemClick(item:String ,postion:Int)
    }
    class ViewHolder(val itemBinding: ItemHadethBinding): RecyclerView.ViewHolder(itemBinding.root) {
      fun bind(title:String)
      {
          itemBinding.hadethName.setText(title)
      }
    }
}