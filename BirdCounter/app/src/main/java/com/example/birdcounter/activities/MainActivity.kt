package com.example.birdcounter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birdcounter.R
import com.example.birdcounter.data.PreferencesManager
import com.example.birdcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateBirdCount()

        binding.bBlueBirdSeen.setOnClickListener { seeBird(R.color.blueBird) }
        binding.bRedBirdSeen.setOnClickListener { seeBird(R.color.redBird) }
        binding.bPurpleBirdSeen.setOnClickListener { seeBird(R.color.purpleBird) }
        binding.bGreenBirdSeen.setOnClickListener { seeBird(R.color.greenBird) }
    }

    fun updateBirdCount()
    {
        counter = PreferencesManager().retrieveBirdCount()
        binding.tvBirdsSeen.text = counter.toString()
        binding.tvBirdsSeen.setBackgroundResource(PreferencesManager().retrieveBirdColor())
    }

    fun seeBird(color: Int)
    {
        counter = PreferencesManager().retrieveBirdCount()
        counter++
        val preferencesManager = PreferencesManager()
        preferencesManager.saveBirdCount(counter)
        preferencesManager.saveBirdColor(color)

        updateBirdCount()
    }
}