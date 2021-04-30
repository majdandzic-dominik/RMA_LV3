package com.example.inspiringpeople.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpeople.databinding.ItemInspiringPersonBinding
import com.example.inspiringpeople.model.InspiringPerson
import com.squareup.picasso.Picasso

class InspiringPeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    fun bind(person: InspiringPerson)
    {
        val itemBinding = ItemInspiringPersonBinding.bind(itemView)
        itemBinding.tvInspiringPersonItemName.text = person.name
        itemBinding.tvInspiringPersonItemDob.text = person.dob
        itemBinding.tvInspringPersonItemDetails.text = person.details
        Picasso.get().load(person.imageSrc).into(itemBinding.ivInspiringPersonItemPicture)
    }
}