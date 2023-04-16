package com.sadapay.test.trending.data.models

import com.google.gson.annotations.SerializedName

data class OwnerDataModel(
    val login: String?,
    @SerializedName("avatar_url") val avatarUrl: String?,
)

data class TrendingItemDataModel(
    val name: String?,
    val owner: OwnerDataModel?,
    val language: String?,
    @SerializedName("stargazers_count") val stargazersCount: Int?,
)

data class TrendingDataModel(
    val items: List<TrendingItemDataModel>
)
