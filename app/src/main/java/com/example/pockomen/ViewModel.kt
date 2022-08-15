package com.example.pockomen


import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pockomen.model.MoviesResponse
import com.example.pockomen.model.Repository
import com.example.pockomen.model.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject
constructor(private val repository:Repository) : ViewModel() {
    private val _response = MutableLiveData<List<Result>>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable
    fun getMovieList() : MutableLiveData<List<Result>>  =  _response

    init {
        getAllMovies()
    }

     fun getAllMovies() {
        repository.getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result -> _response.setValue(result.results) }
            ) { error -> Log.e("viwModel", error.message.toString()) }
    }


    }

