package com.example.pockomen.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.pockomen.database.MovieDao
import com.example.pockomen.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject


class Repository @Inject constructor(
    var apiService: ApiService,
    var movieDao: MovieDao

) {

    fun getMovies(): Observable<MoviesResponse> = apiService.getAllMovies()/* {
     return   apiService.getAllMovies()
    }*/
    fun inserMovie(favourite: Favourite){
        movieDao.insertAllFav(favourite)
    }
    fun deleteMovie(favourite: Favourite){
        movieDao.deleteFav(favourite)
    }
    fun getFavouriteMovies():LiveData<List<Favourite>>{
        return  movieDao.getAllFavourite()
    }
}