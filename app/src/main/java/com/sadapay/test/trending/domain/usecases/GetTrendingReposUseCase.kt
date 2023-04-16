package com.sadapay.test.trending.domain.usecases

import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.domain.repositories.TrendingRepository

interface GetTrendingReposUseCase {
    suspend fun execute(): Result<TrendingModel?>
}

class GetTrendingReposUseCaseImpl(private val repository: TrendingRepository) : GetTrendingReposUseCase {

    override suspend fun execute(): Result<TrendingModel?> {
        return try {
            val repositories = repository.getTrendingRepos()
            Result.success(repositories)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }

}