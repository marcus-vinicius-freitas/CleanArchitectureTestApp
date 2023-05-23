package com.marcusfreitas.test.trending.presentation.di

import com.marcusfreitas.test.trending.data.repositories.FakeTrendingRepository
import com.marcusfreitas.test.trending.data.repositories.TrendingRepository
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCase
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.testing.TestInstallIn

@TestInstallIn(
    components = [ViewModelComponent::class],
    replaces = [DomainModule::class]
)
@Module
class FakeDomainModule {

    @Provides
    fun providesTrendingRepository(): TrendingRepository = FakeTrendingRepository()

    @Provides
    fun providesGetTrendingRepos(repository: TrendingRepository): GetTrendingReposUseCase = GetTrendingReposUseCaseImpl(repository)

}