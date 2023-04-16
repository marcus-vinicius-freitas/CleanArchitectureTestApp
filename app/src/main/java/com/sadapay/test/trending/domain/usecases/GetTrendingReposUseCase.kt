package com.sadapay.test.trending.domain.usecases

import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.domain.repositories.TrendingRepository

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