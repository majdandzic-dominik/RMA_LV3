package com.example.birdcounter.data

import android.content.Context
import com.example.birdcounter.BirdCounter

class PreferencesManager {

    companion object
    {
        const val PREFS_FILE = "BirdCounter"
        const val PREFS_KEY_BIRD_COUNT = 0
        const val PREFS_KEY_BIRD_COLOR = 0
    }

    fun saveBirdColor(color: Int)
    {
        val sharedPreferences = BirdCounter.application.getSharedPreferences("PREFS_FILE", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("PREFS_KEY_BIRD_COLOR", color)
        editor.apply()
    }

    fun retrieveBirdColor(): Int
    {
        val sharedPreferences = BirdCounter.application.getSharedPreferences("PREFS_FILE", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("PREFS_KEY_BIRD_COLOR", 0)
    }

    fun saveBirdCount(count: Int)
    {
        val sharedPreferences = BirdCounter.application.getSharedPreferences("PREFS_FILE", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("PREFS_KEY_BIRD_COUNT", count)
        editor.apply()
    }

    fun retrieveBirdCount(): Int
    {
        val sharedPreferences = BirdCounter.application.getSharedPreferences("PREFS_FILE", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("PREFS_KEY_BIRD_COUNT", 0)
    }
}