package com.marcusfreitas.test.trending.data.mappers

import com.marcusfreitas.test.trending.data.models.TrendingDataModel
import com.marcusfreitas.test.trending.domain.models.OwnerModel
import com.marcusfreitas.test.trending.domain.models.TrendingItemModel
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import javax.inject.Inject

class TrendingMapper @Inject constructor() {

    fun toTrendingModel(dataModel: TrendingDataModel): TrendingModel {
        return TrendingModel(
            dataModel.items.map {
                TrendingItemModel(
                    it.name,
                    it.description,
                    OwnerModel(
                        it.owner?.login,
                        it.owner?.avatarUrl
                    ),
                    it.language,
                    it.stargazersCount
                )
            }
        )
    }

}