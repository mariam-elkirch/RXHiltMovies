package com.example.pockomen.favourite.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pockomen.databinding.ActivityFavouriteBinding
import com.example.pockomen.displayMovies.view.MainActivity
import com.example.pockomen.displayMovies.viewmodel.ViewModel
import com.example.pockomen.favourite.viewmodel.FavouriteAdapter
import com.example.pockomen.favourite.viewmodel.FavouriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteActivity : AppCompatActivity() {
    private val binding by lazy {ActivityFavouriteBinding.inflate(layoutInflater) }

    private val favAdapter by lazy { FavouriteAdapter() }

    private lateinit var viewModel: FavouriteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.favouriteRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.favouriteRecyclerView.adapter = favAdapter



        viewModel = ViewModelProvider(this)[FavouriteViewModel::class.java]

       viewModel.getAllFav().observe(this) {

           favAdapter.setData(it)
        }

        binding.HomeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }

}