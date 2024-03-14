package com.example.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.source.local.entity.MarvelEntity

@Database(entities = [MarvelEntity::class], version = 1, exportSchema = false)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelDao
}