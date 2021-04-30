package com.example.birdcounter

import android.app.Application

class BirdCounter : Application() {

    companion object{
        lateinit var application: BirdCounter
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}