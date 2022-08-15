package com.example.pockomen.network


import com.example.pockomen.model.MoviesResponse
import retrofit2.Response
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("movie?api_key=bdee2da50a6d74db54386e74ecb18c4f")
  //  suspend fun getAllMovies(): Response<MoviesResponse>
   fun getAllMovies(): Observable<MoviesResponse>
}