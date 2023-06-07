package com.marcusfreitas.test.trending.data.repositories

import com.marcusfreitas.test.trending.data.mappers.TrendingMapper
import com.marcusfreitas.test.trending.data.service.ApiService
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import javax.inject.Inject

interface TrendingRepository {
    suspend fun getTrendingRepos(): TrendingModel?
}

/**
 * A repository class that extends [TrendingRepository] and is responsible to
 * call the [ApiService]
 *
 * @param[apiService] The [ApiService] instance that are going to be used and is injected in this constructor
 * @param[mapper] The [TrendingMapper] that will be used to map the [TrendingDataModel] into [TrendingModel]
 * this parameter is also injected into the constructor
 */
class TrendingRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: TrendingMapper
) : TrendingRepository {

    /**
     * This method returns the trending github repositories
     */
    override suspend fun getTrendingRepos(): TrendingModel? {
        val result = apiService.getTrendingRepositories().body()
        return if (result != null) {
            mapper.toTrendingModel(result)
        } else {
            null
        }
    }

}