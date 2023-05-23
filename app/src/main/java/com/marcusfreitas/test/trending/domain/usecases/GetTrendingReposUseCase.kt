package com.marcusfreitas.test.trending.domain.usecases

import com.marcusfreitas.test.trending.domain.models.TrendingModel
import com.marcusfreitas.test.trending.data.repositories.TrendingRepository

interface GetTrendingReposUseCase {
    suspend fun execute(): TrendingModel?
}

class GetTrendingReposUseCaseImpl(private val repository: TrendingRepository) : GetTrendingReposUseCase {

    override suspend fun execute(): TrendingModel? {
        return try {
            repository.getTrendingRepos()
        } catch (exception: Exception) {
            null
        }
    }

}