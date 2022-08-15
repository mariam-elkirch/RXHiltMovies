package com.example.pockomen.model

import android.content.Context
import com.example.pockomen.network.ApiService
import io.reactivex.Observable
import javax.inject.Inject


class Repository @Inject constructor(
    var apiService: ApiService,
    //var localSource: LocalSource,

) {
    // private lateinit var movieApiService : ApiService
    fun getMovies(): Observable<MoviesResponse> = apiService.getAllMovies()/* {
     return   apiService.getAllMovies()
    }*/

}