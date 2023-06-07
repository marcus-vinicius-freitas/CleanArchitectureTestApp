package com.marcusfreitas.test.trending.data.mappers

import com.marcusfreitas.test.trending.data.models.TrendingDataModel
import com.marcusfreitas.test.trending.domain.models.OwnerModel
import com.marcusfreitas.test.trending.domain.models.TrendingItemModel
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import javax.inject.Inject

/**
 * A mapper class to help mapping data objects into models that are going to be consumed by the view
 */
class TrendingMapper @Inject constructor() {

    /**
     * An mapper function that maps a [TrandingDataModel] into a [TrendingModel]
     *
     * @param[dataModel] the data model that will be mapped
     */
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