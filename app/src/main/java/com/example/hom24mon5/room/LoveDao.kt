package com.example.hom24mon5.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hom24mon5.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(lovemodel: LoveModel)

    @Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM love_table ORDER BY fname ASC ")
    fun getAllLoveModelByAlphabetAZ(): List<LoveModel>
}