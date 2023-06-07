package com.marcusfreitas.test.trending.data.service

import com.marcusfreitas.test.trending.data.models.TrendingDataModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * A interface that provides the API calls
 */
interface ApiService {

    /**
     * This signature provides the API call that provides the trending github repositories
     * @return Returns a [Response] object that has a [TrendingDataModel] with the result
     * the response object provides a success or failure result
     */
    @GET("search/repositories?q=android&sort=stars")
    suspend fun getTrendingRepositories(): Response<TrendingDataModel>

}