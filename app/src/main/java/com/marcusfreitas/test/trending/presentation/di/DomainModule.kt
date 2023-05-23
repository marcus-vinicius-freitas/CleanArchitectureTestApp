package com.marcusfreitas.test.trending.presentation.di

import com.marcusfreitas.test.trending.data.repositories.TrendingRepository
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCase
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DomainModule {

    @Singleton
    @Provides
    fun providesGetTrendingReposUseCase(repository: TrendingRepository): GetTrendingReposUseCase {
        return GetTrendingReposUseCaseImpl(repository)
    }

}