package com.john.fbi_mostwanted.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.john.fbi_mostwanted.databinding.ItemWantedBinding
import com.john.fbi_mostwanted.model.Item


class PeopleAdapter (
   private var criminalsList: MutableList<Item> = mutableListOf()
        ): RecyclerView.Adapter<Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemWantedBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(criminalsList[position])
    }

    override fun getItemCount(): Int = criminalsList.size

    fun update(criminals : List<Item>){
        criminalsList.clear()
        criminalsList.addAll(criminals)
        notifyDataSetChanged()

    }
}

class Holder(
    private  val binding: ItemWantedBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind (criminalItem: Item){
        binding.tvName.text = criminalItem.title
        binding.tvNationality.text = criminalItem.nationality
        binding.tvRace.text = criminalItem.race
    }
}