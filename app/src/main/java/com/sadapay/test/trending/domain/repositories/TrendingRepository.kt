package com.sadapay.test.trending.domain.repositories

import com.sadapay.test.trending.data.mappers.TrendingMapper
import com.sadapay.test.trending.data.service.ApiService
import com.sadapay.test.trending.domain.models.TrendingModel
import javax.inject.Inject

interface TrendingRepository {
    suspend fun getTrendingRepos(): TrendingModel?
}

class TrendingRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: TrendingMapper
) : TrendingRepository {

    override suspend fun getTrendingRepos(): TrendingModel? {
        val result = apiService.getTrendingRepositories().body()
        return if (result != null) {
            null
        } else {
            null
        }
    }

}