package com.example.pockomen.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.pockomen.model.Favourite


@Dao
public interface MovieDao {
    @Query("SELECT * From favourite")
    fun getAllFavourite(): LiveData<List<Favourite>>

    @Insert
     fun insertAllFav(fav:Favourite)

    @Delete
     fun deleteFav(fav: Favourite)
}