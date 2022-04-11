package com.john.fbi_mostwanted.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.john.fbi_mostwanted.databinding.ItemWantedBinding
import com.john.fbi_mostwanted.model.Item
import com.squareup.picasso.Picasso

class PeopleAdapter (
  //  private var peopleAdapterListener: PeopleAdapterListener,
   private var criminalsList: MutableList<Item> = mutableListOf(),
   private val openDet: (Item) -> Unit
        ): RecyclerView.Adapter<Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemWantedBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(criminalsList[position], openDet)

//        holder.itemView.setOnClickListener {
//    //        peopleAdapterListener.openCriminal(criminalsList[position])
//    //        openDet()
//        }
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

    fun bind (criminalItem: Item, openDet: (Item)-> Unit){
        binding.tvName.text = criminalItem.title
        binding.tvNationality.text = criminalItem.nationality
        binding.tvRace.text = criminalItem.race

        criminalItem.images[0]?.let { Log.d("IMAGE_DATA", it.large) }
        //Picasso
        Picasso.get().load(criminalItem.images[0]?.large)
            .resize(200,200)
            .centerCrop()
            .into(binding.imgFace)

        itemView.setOnClickListener { openDet(criminalItem) }
    }
}