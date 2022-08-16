package com.example.pockomen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pockomen.model.Favourite

@Database(entities = [Favourite::class], version =1)

abstract class DataBase: RoomDatabase() {
  // public abstract fun movieDao(): MovieDao?
  abstract fun movieDao(): MovieDao
}