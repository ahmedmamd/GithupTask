package com.example.githup.data.repository

import androidx.paging.*
import com.example.githup.data.models.RepoModel
import com.example.githup.data.source.remote.EndPoints
import com.example.githup.paging.RepoDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class SetRepositoryImp @Inject constructor(private val endPoints: EndPoints)
{

    fun getRepo():Flow<PagingData<RepoModel>>{
       return Pager(
           config = PagingConfig(
               pageSize = 1,
               maxSize = 10,
               enablePlaceholders = false
           ),
           pagingSourceFactory = {
               RepoDataSource(endPoints)
           }
       ).flow
   }

}