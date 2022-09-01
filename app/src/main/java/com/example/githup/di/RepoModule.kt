package com.example.githup.di

import com.example.githup.data.repository.SetRepositoryImp
import com.example.githup.data.source.remote.EndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object RepoModule {

    @ViewModelScoped
    @Provides
    fun provideMyPropertiesRepository(endPoints: EndPoints): SetRepositoryImp {
        return SetRepositoryImp(endPoints)
    }

}