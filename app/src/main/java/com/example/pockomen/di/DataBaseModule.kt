package com.example.pockomen.di

import android.app.Application
import androidx.room.Room
import com.example.pockomen.database.DataBase
import com.example.pockomen.database.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.annotation.Nullable
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBaseInstance(application: Application): DataBase {

        return Room.databaseBuilder(
           application,
            DataBase::class.java,
            "movie"
        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    }

    @Provides
    @Singleton
    fun provideDao(dataBase: DataBase): MovieDao {
        return dataBase.movieDao()
    }//i will use only dao provide, another fun hilt use to pass db
}