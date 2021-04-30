package com.example.inspiringpeople.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "inspiring_people_table")
data class InspiringPerson(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val name: String,
    val dob: String,
    val details: String,
    val imageSrc: String
) : Serializable