package com.rak12.retroflipz.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GamesEntity::class], version = 1)

abstract class Database : RoomDatabase() {
    abstract fun gamesdao(): Dao

}

