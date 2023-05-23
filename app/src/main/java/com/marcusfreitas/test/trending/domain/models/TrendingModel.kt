package com.marcusfreitas.test.trending.domain.models

data class TrendingItemModel(
    val name: String?,
    val description: String?,
    val owner: OwnerModel?,
    val language: String?,
    val stargazersCount: Int?,
)

data class OwnerModel(
    val login: String?,
    val avatarUrl: String?,
)

data class TrendingModel(
    val items: List<TrendingItemModel>,
)