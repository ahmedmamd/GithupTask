package com.example.githup.di

import android.content.Context
import androidx.room.Room
import com.example.githup.data.source.local.RepoDao
import com.example.githup.data.source.local.RepoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : RepoDatabase =
        Room.databaseBuilder(context, RepoDatabase::class.java, "Repo_database")
            .build()

    @Provides
    @Singleton
    fun provideUserDao(database: RepoDatabase) : RepoDao =
        database.repoDao()

}