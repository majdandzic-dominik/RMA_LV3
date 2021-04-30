package com.example.inspiringpeople.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.inspiringpeople.R
import com.example.inspiringpeople.databinding.ActivityMainBinding
import com.example.inspiringpeople.fragments.InspiringPersonDetailsFragment
import com.example.inspiringpeople.fragments.InspiringPersonListFragment
import com.example.inspiringpeople.listeners.OnPersonSelectedListener
import com.example.inspiringpeople.model.InspiringPerson

class MainActivity
    : AppCompatActivity(), OnPersonSelectedListener
{

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.fabAddInspiringPerson.setOnClickListener{createNewPerson()}
        setContentView(mainBinding.root)



        if(savedInstanceState == null)
        {
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, InspiringPersonListFragment.create(), InspiringPersonListFragment.TAG)
                .commit()
        }
    }

    private fun createNewPerson()
    {
        val newIntent = Intent(this, NewInspiringPersonActivity::class.java)
        startActivity(newIntent)
    }


    override fun OnPersonSelected(person: InspiringPerson)
    {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer, InspiringPersonDetailsFragment.create(person), InspiringPersonDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

}