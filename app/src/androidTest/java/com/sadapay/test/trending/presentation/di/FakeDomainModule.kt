package com.sadapay.test.trending.presentation.di

import com.sadapay.test.trending.domain.repositories.FakeTrendingRepository
import com.sadapay.test.trending.domain.repositories.TrendingRepository
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCase
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
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