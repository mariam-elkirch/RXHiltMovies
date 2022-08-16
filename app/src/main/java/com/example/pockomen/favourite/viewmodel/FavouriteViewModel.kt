package com.example.pockomen.favourite.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pockomen.model.Favourite
import com.example.pockomen.model.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject
constructor(private val repository: Repository) : ViewModel() {
    fun getAllFav(): LiveData<List<Favourite>> {
        Log.i("tag","fav view model")
        return repository.getFavouriteMovies()
    }

    fun deletePokemon(favourite: Favourite) {
        repository.deleteMovie(favourite)
    }
}