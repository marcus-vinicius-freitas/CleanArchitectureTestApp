package com.sadapay.test.trending.presentation.di

import com.sadapay.test.trending.data.mappers.TrendingMapper
import com.sadapay.test.trending.data.service.ApiService
import com.sadapay.test.trending.domain.repositories.TrendingRepository
import com.sadapay.test.trending.domain.repositories.TrendingRepositoryImpl
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCase
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
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
    fun providesTrendingRepository(
        service: ApiService,
        mapper: TrendingMapper
    ): TrendingRepository {
        return TrendingRepositoryImpl(
            service,
            mapper
        )
    }

    @Singleton
    @Provides
    fun providesGetTrendingReposUseCase(repository: TrendingRepository): GetTrendingReposUseCase {
        return GetTrendingReposUseCaseImpl(repository)
    }

}