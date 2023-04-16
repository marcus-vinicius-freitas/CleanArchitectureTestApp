package com.sadapay.test.trending.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TrendingViewModel : ViewModel() {

    val trendingReposState: MutableState<String?> = mutableStateOf(null)

    fun getTrendingRepos() {

    }

}