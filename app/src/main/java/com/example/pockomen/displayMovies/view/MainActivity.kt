package com.example.pockomen.displayMovies.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pockomen.displayMovies.viewmodel.ViewModel
import com.example.pockomen.databinding.ActivityMainBinding
import com.example.pockomen.favourite.view.FavouriteActivity
import com.example.pockomen.model.Favourite
import com.example.pockomen.model.Result
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val moviesAdapter by lazy { MoviesAdapter() }

    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.moviesRecyclerView.adapter = moviesAdapter



        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.getMovieList()
        viewModel.responseTvShow.observe(this) {
            Log.i("tag","Mainn"+it)
            moviesAdapter.setData(it)
        }
        viewModel.errorMessage.observe(this){
            Log.i("tag","Errorr"+it.toString())
        }
        binding.favouriteButton.setOnClickListener {
            val intent = Intent(this, FavouriteActivity::class.java)
            startActivity(intent)

        }
        setUpSwipe()
    }

    fun  setUpSwipe(){
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {


                val position = viewHolder.adapterPosition

               val  movie  : Result  =   moviesAdapter.getMovieByPosition(position)
                val favMovie = Favourite(movie.id,movie.poster_path,movie.title)
                viewModel.insertPokemon(favMovie)
                moviesAdapter.notifyDataSetChanged();
                Toast.makeText(this@MainActivity, "Movie added to database", Toast.LENGTH_SHORT).show();

            }
            // at last we are adding this
            // to our recycler view.
        }).attachToRecyclerView(binding.moviesRecyclerView)

    }



}