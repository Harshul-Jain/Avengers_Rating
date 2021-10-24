package com.example.avengers_rating.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.avengers_rating.data.models.AvengersModel

@Dao
interface AvengerDao {

    @Insert()
    suspend fun insertAvenger(avengersModel: AvengersModel): Long

    @Query("SELECT * from AvengersModel ")
    fun getAvenger(): LiveData<List<AvengersModel>>

    @Query("Update AvengersModel set rated = 'true' and stars=:star where id=:avengerId  ")
    fun updateAvenger(avengerId: Long, star: Int)
}