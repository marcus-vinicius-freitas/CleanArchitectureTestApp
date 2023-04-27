package com.sadapay.test.trending.presentation.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TrendingViewModel @Inject constructor(
    private val getTrendingReposUseCase: GetTrendingReposUseCase
) : ViewModel() {

    val trendingReposState: MutableState<TrendingModel?> = mutableStateOf(null)
    val loadingState: MutableState<Boolean> = mutableStateOf(false)

    fun getTrendingRepos() {
        viewModelScope.launch {
            try {
                loadingState.value = true
                val result = getTrendingReposUseCase.execute()
                loadingState.value = false
                when {
                    result != null -> {
                        trendingReposState.value = result
                    }
                    else -> {
                        trendingReposState.value = null
                    }
                }
            } catch (e: Exception) {
                trendingReposState.value = null
            }
        }
    }

}