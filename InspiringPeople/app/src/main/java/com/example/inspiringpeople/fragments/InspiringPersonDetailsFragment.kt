package com.example.inspiringpeople.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inspiringpeople.activities.NewInspiringPersonActivity
import com.example.inspiringpeople.activities.UpdateInspiringPersonActivity
import com.example.inspiringpeople.data.InspiringPeopleDatabaseBuilder
import com.example.inspiringpeople.data.InspiringPersonDao
import com.example.inspiringpeople.databinding.FragmentInspiringPersonDetailsBinding
import com.example.inspiringpeople.model.InspiringPerson
import com.squareup.picasso.Picasso

class InspiringPersonDetailsFragment : Fragment()
{
    lateinit var personDetailsBinding: FragmentInspiringPersonDetailsBinding

    private val inspiringPeopleRepository: InspiringPersonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPersonDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        personDetailsBinding = FragmentInspiringPersonDetailsBinding.inflate(
            inflater,
            container,
            false
        )


        arguments?.let {
            val person = it.getSerializable(KEY_NOTE) as InspiringPerson
            personDetailsBinding.bDeletePerson.setOnClickListener{deletePerson(person)}
            personDetailsBinding.bUpdatePerson.setOnClickListener{updatePerson(person)}

            personDetailsBinding.tvInspiringPersonName.text = person.name
            personDetailsBinding.tvInspiringPersonDob.text = person.dob
            personDetailsBinding.tvInspiringPersonDetails.text = person.details
            Picasso.get().load(person.imageSrc).into(personDetailsBinding.ivInspiringPersonPicture)
        }
        return personDetailsBinding.root
    }

    private fun deletePerson(person: InspiringPerson)
    {
        inspiringPeopleRepository.deletePerson(person)
        activity?.supportFragmentManager?.popBackStack()
    }

    private fun updatePerson(person: InspiringPerson)
    {
        val newIntent = Intent(activity, UpdateInspiringPersonActivity::class.java)
        newIntent.putExtra("id", person.id)
        startActivity(newIntent)
        activity?.supportFragmentManager?.popBackStack()
    }

    companion object
    {
        const val TAG = "Details"
        private const val KEY_NOTE = "InspiringPerson"

        fun create(person: InspiringPerson): InspiringPersonDetailsFragment
        {
            val args = Bundle()
            args.putSerializable(KEY_NOTE, person)
            val fragment =  InspiringPersonDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}