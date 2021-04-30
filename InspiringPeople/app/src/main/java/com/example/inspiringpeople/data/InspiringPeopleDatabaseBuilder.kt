package com.example.inspiringpeople.data

import androidx.room.Room
import com.example.inspiringpeople.InspiringPeople

object InspiringPeopleDatabaseBuilder
{
    private var instance: InspiringPeopleDatabase? = null

    fun getInstance(): InspiringPeopleDatabase
    {
        synchronized(InspiringPeopleDatabase::class)
        {
            if(instance == null)
            {
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): InspiringPeopleDatabase
    {
        return Room.databaseBuilder(InspiringPeople.application, InspiringPeopleDatabase::class.java, InspiringPeopleDatabase.INSTANCE)
            .allowMainThreadQueries()
            .build()
    }

}