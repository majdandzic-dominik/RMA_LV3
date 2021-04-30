package com.example.inspiringpeople.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inspiringpeople.adapters.InspiringPeopleAdapter
import com.example.inspiringpeople.data.InspiringPeopleDatabaseBuilder
import com.example.inspiringpeople.data.InspiringPersonDao
import com.example.inspiringpeople.data.PeopleRepository
import com.example.inspiringpeople.databinding.FragmentInspiringPersonListBinding
import com.example.inspiringpeople.listeners.OnPersonSelectedListener

class InspiringPersonListFragment : Fragment()
{
    private lateinit var onPersonSelectedListener: OnPersonSelectedListener
    private lateinit var inspiringPersonListBinding: FragmentInspiringPersonListBinding
    private val peopleRepository: InspiringPersonDao by lazy {
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPersonDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        inspiringPersonListBinding = FragmentInspiringPersonListBinding.inflate(inflater, container, false)
        setUpRecyclerVieW()
        return inspiringPersonListBinding.root
    }

    private fun setUpRecyclerVieW()
    {
        inspiringPersonListBinding.rvInspiringPeople.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        inspiringPersonListBinding.rvInspiringPeople.adapter = InspiringPeopleAdapter(peopleRepository.getPeople(), onPersonSelectedListener)
    }

    override fun onAttach(context: Context)
    {
        super.onAttach(context)
        if(context is OnPersonSelectedListener)
        {
            onPersonSelectedListener = context
        }
    }

    override fun onResume()
    {
        super.onResume()
        (inspiringPersonListBinding.rvInspiringPeople.adapter as InspiringPeopleAdapter).update(peopleRepository.getPeople())
    }

    companion object
    {
        const val TAG = "People list"
        fun create(): InspiringPersonListFragment
        {
            return InspiringPersonListFragment()
        }
    }

}