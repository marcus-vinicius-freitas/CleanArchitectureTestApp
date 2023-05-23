package com.marcusfreitas.test.trending.data.service

import com.marcusfreitas.test.trending.data.models.TrendingDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("search/repositories?q=android&sort=stars")
    suspend fun getTrendingRepositories(): Response<TrendingDataModel>

}