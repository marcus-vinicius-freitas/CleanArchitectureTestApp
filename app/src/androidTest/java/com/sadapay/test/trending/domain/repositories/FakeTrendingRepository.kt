package com.sadapay.test.trending.domain.repositories

import com.sadapay.test.trending.domain.models.OwnerModel
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel
import javax.inject.Inject

class FakeTrendingRepository @Inject constructor() : TrendingRepository {

    override suspend fun getTrendingRepos(): TrendingModel {
        return TrendingModel(
            listOf(
                TrendingItemModel(
                    name = "repo1",
                    description = "description1",
                    owner = OwnerModel(
                        login = "user1",
                        avatarUrl = "https://br.web.img2.acsta.net/c_310_420/medias/nmedia/18/92/22/35/20187351.jpg"
                    ),
                    language = "",
                    stargazersCount = null
                ),
                TrendingItemModel(
                    name = "repo2",
                    description = "description2",
                    owner = OwnerModel(
                        login = "user2",
                        avatarUrl = "https://br.web.img2.acsta.net/c_310_420/medias/nmedia/18/92/22/35/20187351.jpg"
                    ),
                    language = "",
                    stargazersCount = null
                ),
                TrendingItemModel(
                    name = "repo3",
                    description = "description3",
                    owner = OwnerModel(
                        login = "user3",
                        avatarUrl = "https://br.web.img2.acsta.net/c_310_420/medias/nmedia/18/92/22/35/20187351.jpg"
                    ),
                    language = "",
                    stargazersCount = null
                )
            )
        )
    }

}