package com.example.githup.data.source.remote

import com.example.githup.data.models.RepoModel
import com.example.githup.data.source.remote.api.Home.HOME
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPoints {

    @GET(HOME)
    suspend fun callHome(
        @Query("page") page:Int
//        @Query("per_page") perPage:Int,

    ): List<RepoModel>

}