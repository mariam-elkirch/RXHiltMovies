package com.example.pockomen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pockomen.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val moviesAdapter by lazy { MoviesAdapter() }

    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.moviesRecyclerView.adapter = moviesAdapter

        Log.i("tag","Main")

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.getMovieList()
        viewModel.getMovieList().observe(this) {
            Log.i("tag","Mainn"+it)
            moviesAdapter.setData(it)
        }
        viewModel.errorMessage.observe(this){
            Log.i("tag","Errorr"+it.toString())
        }

    }
}