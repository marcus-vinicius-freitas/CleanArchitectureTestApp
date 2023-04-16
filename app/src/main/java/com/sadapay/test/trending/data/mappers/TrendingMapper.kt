package com.sadapay.test.trending.data.mappers

import com.sadapay.test.trending.data.models.TrendingDataModel
import com.sadapay.test.trending.domain.models.OwnerModel
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel
import javax.inject.Inject

class TrendingMapper @Inject constructor() {

    fun toTrendingModel(dataModel: TrendingDataModel): TrendingModel {
        return TrendingModel(
            dataModel.items.map {
                TrendingItemModel(
                    it.name,
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