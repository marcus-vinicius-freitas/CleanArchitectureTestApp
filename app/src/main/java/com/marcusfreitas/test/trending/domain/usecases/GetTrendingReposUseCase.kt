package com.marcusfreitas.test.trending.domain.usecases

import com.marcusfreitas.test.trending.data.repositories.TrendingRepository
import com.marcusfreitas.test.trending.domain.models.TrendingModel

interface GetTrendingReposUseCase {
    suspend fun execute(): TrendingModel?
}

/**
 * A use case class that extends [GetTrendingReposUseCase] and is responsible to
 * provide the trending github repositories to the view model
 *
 * @param[repository] The [TrendingRepository] instance that are going to be used and is injected in this constructor
 */
class GetTrendingReposUseCaseImpl(private val repository: TrendingRepository) : GetTrendingReposUseCase {

    override suspend fun execute(): TrendingModel? {
        return try {
            repository.getTrendingRepos()
        } catch (exception: Exception) {
            null
        }
    }

}