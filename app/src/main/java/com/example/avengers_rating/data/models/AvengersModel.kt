package com.example.avengers_rating.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AvengersModel(

    var avenger_name: String,
    var avenger_image:String,
    var rated: Boolean = false,
    var stars: Int = 1,
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
)