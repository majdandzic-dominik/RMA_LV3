package com.example.inspiringpeople.data


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inspiringpeople.model.InspiringPerson

@Database(entities = [InspiringPerson::class], version = 1, exportSchema = false)
abstract class InspiringPeopleDatabase : RoomDatabase()
{
    abstract fun inspiringPersonDao(): InspiringPersonDao

    companion object
    {
        const val INSTANCE = "inspiring_people_db"
    }
}