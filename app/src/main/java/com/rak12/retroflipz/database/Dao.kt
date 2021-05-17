package com.rak12.retroflipz.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {
    @Insert
    fun insert(gamesEntity: GamesEntity)

    @Delete
    fun delete(gamesEntity: GamesEntity)

    @Query("SELECT * FROM CUISINE")
    fun getall(): List<GamesEntity>

    @Query("SELECT * FROM CUISINE WHERE ID=:id")
    fun getbyid(id: Int): GamesEntity



}