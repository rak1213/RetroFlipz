package com.rak12.retroflipz.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "cuisine")
    data class GamesEntity(
            @PrimaryKey  @ColumnInfo(name = "id") val id: Int,
            @ColumnInfo(name = "name") val name: String,
            @ColumnInfo(name = "img") val img: String,
            @ColumnInfo(name = "link") val link: String,
            @ColumnInfo(name = "gd") val gd :String

    )
