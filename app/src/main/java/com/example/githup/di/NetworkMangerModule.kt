package com.example.githup.di

import android.content.Context
import com.example.githup.data.manger.APIsClientManager
import com.example.githup.data.source.remote.EndPoints

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkMangerModule {

    @Singleton
    @Provides
    fun provideNetworkManger(endPoints: EndPoints, @ApplicationContext context: Context ): APIsClientManager {
        return APIsClientManager(endPoints , context)
    }

}