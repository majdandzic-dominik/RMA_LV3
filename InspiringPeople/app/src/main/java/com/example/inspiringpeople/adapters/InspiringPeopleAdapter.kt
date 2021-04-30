package com.example.inspiringpeople.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inspiringpeople.R
import com.example.inspiringpeople.listeners.OnPersonSelectedListener
import com.example.inspiringpeople.model.InspiringPerson

class InspiringPeopleAdapter(
    people: List<InspiringPerson>,
    private val listener: OnPersonSelectedListener
) : RecyclerView.Adapter<InspiringPeopleViewHolder>()
{

    private val people: MutableList<InspiringPerson> = mutableListOf()
    init
    {
        update(people)
    }

    fun update(people: List<InspiringPerson>)
    {
        this.people.clear()
        this.people.addAll(people)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InspiringPeopleViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_inspiring_person, parent, false)
        return InspiringPeopleViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return people.size
    }

    override fun onBindViewHolder(holder: InspiringPeopleViewHolder, position: Int)
    {
        val person = people[position]
        holder.bind(person)
        holder.itemView.setOnClickListener { listener.OnPersonSelected(person) }
    }

}