package com.sadapay.test.trending.domain.repositories

import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel
import javax.inject.Inject

class FakeTrendingRepository @Inject constructor() : TrendingRepository {

    override suspend fun getTrendingRepos(): TrendingModel {
        return TrendingModel(
            listOf(
                TrendingItemModel("repo1", null, null, null),
                TrendingItemModel("repo2", null, null, null),
                TrendingItemModel("repo3", null, null, null)
            )
        )
    }

}