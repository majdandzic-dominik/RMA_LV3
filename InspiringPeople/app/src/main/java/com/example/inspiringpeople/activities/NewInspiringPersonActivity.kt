package com.example.inspiringpeople.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inspiringpeople.data.InspiringPeopleDatabaseBuilder
import com.example.inspiringpeople.data.InspiringPersonDao
import com.example.inspiringpeople.databinding.ActivityNewInspiringPersonBinding
import com.example.inspiringpeople.model.InspiringPerson

class NewInspiringPersonActivity: AppCompatActivity()
{
    private lateinit var newInspiringPersonBinding: ActivityNewInspiringPersonBinding
    private val inspiringPeopleRepository: InspiringPersonDao by lazy{
        InspiringPeopleDatabaseBuilder.getInstance().inspiringPersonDao()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        newInspiringPersonBinding = ActivityNewInspiringPersonBinding.inflate(layoutInflater)
        newInspiringPersonBinding.bNewPersonSave.setOnClickListener{savePerson()}
        setContentView(newInspiringPersonBinding.root)
    }

    private fun savePerson()
    {
        val name = newInspiringPersonBinding.etNewPersonNameInput.text.toString()
        val details = newInspiringPersonBinding.etNewPersonDetailsInput.text.toString()
        val imgSrc = newInspiringPersonBinding.etNewPersonImgInput.text.toString()
        val dob = newInspiringPersonBinding.etNewPersonDobInput.text.toString()
        val person = InspiringPerson(0, name, dob, details, imgSrc)
        inspiringPeopleRepository.addPerson(person)
        finish()
    }
}
