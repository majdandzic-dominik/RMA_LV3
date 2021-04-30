package com.example.inspiringpeople.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inspiringpeople.data.InspiringPeopleDatabaseBuilder
import com.example.inspiringpeople.data.InspiringPersonDao
import com.example.inspiringpeople.databinding.ActivityNewInspiringPersonBinding
import com.example.inspiringpeople.databinding.ActivityUpdateInspiringPersonBinding
import com.example.inspiringpeople.model.InspiringPerson
import java.io.Serializable

class UpdateInspiringPersonActivity : AppCompatActivity(), Serializable
{
    private lateinit var updateInspiringPersonBinding: ActivityUpdateInspiringPersonBinding
    private val inspiringPeopleRepository: InspiringPersonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPersonDao()
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        updateInspiringPersonBinding = ActivityUpdateInspiringPersonBinding.inflate(layoutInflater)
        updateInspiringPersonBinding.bUpdatePersonSave.setOnClickListener{savePerson()}
        setContentView(updateInspiringPersonBinding.root)
        populateFields()
    }

    fun populateFields()
    {
        val id = intent.getLongExtra("id", 0)
        var person = inspiringPeopleRepository.getPerson(id)
        updateInspiringPersonBinding.etUpdatePersonNameInput.setText(person.name)
        updateInspiringPersonBinding.etUpdatePersonDetailsInput.setText(person.details)
        updateInspiringPersonBinding.etUpdatePersonImgInput.setText(person.imageSrc)
        updateInspiringPersonBinding.etUpdatePersonDobInput.setText(person.dob)
    }

    private fun savePerson()
    {   val id = intent.getLongExtra("id", 0)
        val name = updateInspiringPersonBinding.etUpdatePersonNameInput.text.toString()
        val details = updateInspiringPersonBinding.etUpdatePersonDetailsInput.text.toString()
        val imgSrc = updateInspiringPersonBinding.etUpdatePersonImgInput.text.toString()
        val dob = updateInspiringPersonBinding.etUpdatePersonDobInput.text.toString()
        val person = InspiringPerson(id, name, dob, details, imgSrc)
        inspiringPeopleRepository.addPerson(person)
        finish()
    }
}