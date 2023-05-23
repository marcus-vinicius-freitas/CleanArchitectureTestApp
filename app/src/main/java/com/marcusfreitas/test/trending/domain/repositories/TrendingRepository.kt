package com.marcusfreitas.test.trending.domain.repositories

import com.marcusfreitas.test.trending.data.mappers.TrendingMapper
import com.marcusfreitas.test.trending.data.service.ApiService
import com.marcusfreitas.test.trending.domain.models.TrendingModel
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
            mapper.toTrendingModel(result)
        } else {
            null
        }
    }

}