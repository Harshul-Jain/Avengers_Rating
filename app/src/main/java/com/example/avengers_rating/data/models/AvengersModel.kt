package com.example.avengers_rating.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AvengersModel(

    var avenger_name: String,
    var rated: Boolean,
    var stars: Int = 1,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)