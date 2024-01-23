package com.example.islamy.islamy.ui.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemSuraBinding

class SuraRecyclerAdapter(private val chapterList: List<String>): RecyclerView.Adapter<SuraRecyclerAdapter.ViewHolder>() {

    lateinit var itemBinding: ItemSuraBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemBinding=ItemSuraBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
      return chapterList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = chapterList[position]
        holder.bind(title)
        onItemClickListner?.let { listner->
            holder.itemBinding.suraTittle.setOnClickListener {
           listner.onItemClick(title, position)
        }  }

    }
    var onItemClickListner:OnItemClickListner?=null
   fun interface OnItemClickListner{
        fun onItemClick(item:String ,postion:Int)

    }
    class ViewHolder(val itemBinding: ItemSuraBinding): RecyclerView.ViewHolder(itemBinding.root) {
      fun bind(title:String)
      {
          itemBinding.suraTittle.setText(title)
      }
    }
}