package com.sadapay.test.trending.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sadapay.test.trending.domain.models.TrendingModel

class TrendingViewModel : ViewModel() {

    val trendingReposState: MutableState<TrendingModel?> = mutableStateOf(null)

    fun getTrendingRepos() {
        trendingReposState.value = null
    }

}