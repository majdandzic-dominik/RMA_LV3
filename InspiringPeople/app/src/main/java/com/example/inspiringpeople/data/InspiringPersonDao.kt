package com.example.inspiringpeople.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.inspiringpeople.model.InspiringPerson

@Dao
interface InspiringPersonDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPerson(person: InspiringPerson)

    @Query("SELECT * FROM inspiring_people_table")
    fun getPeople(): List<InspiringPerson>

    @Delete
    fun deletePerson(person: InspiringPerson)

    @Query("SELECT * FROM inspiring_people_table WHERE id=:id")
    fun getPerson(id: Long): InspiringPerson
}