package com.sadapay.test.trending.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel

class TrendingViewModel : ViewModel() {

    val trendingReposState: MutableState<TrendingModel?> = mutableStateOf(null)

    fun getTrendingRepos() {
        trendingReposState.value = TrendingModel(
            listOf(
                TrendingItemModel(
                    name = "test",
                    owner = null,
                    language = null,
                    stargazersCount = null
                )
            )
        )
    }

}