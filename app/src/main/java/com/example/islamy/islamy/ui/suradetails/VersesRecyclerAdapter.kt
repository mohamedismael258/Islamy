package com.example.islamy.islamy.ui.suradetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.ItemSuraBinding
import com.example.islamy.databinding.ItemVersesBinding

class VersesRecyclerAdapter(private val verses: List<String>): RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {

    lateinit var itemBinding: ItemSuraBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val itemBinding=ItemVersesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
      return verses.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val title = verses[position]
        holder.bind(title)

    }
    var onItemClickListner:OnItemClickListner?=null
   fun interface OnItemClickListner{
        fun onItemClick(item:String ,postion:Int)

    }
    class ViewHolder(val itemBinding: ItemVersesBinding): RecyclerView.ViewHolder(itemBinding.root) {
      fun bind(sura:String)
      {
          itemBinding.suraConten.setText(sura)
      }
    }
}