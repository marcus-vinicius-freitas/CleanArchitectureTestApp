package com.marcusfreitas.test.trending.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcusfreitas.test.trending.data.repositories.TrendingRepository
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A view model class that is responsible to provide the trending github repositories to the view
 *
 * @param[getTrendingReposUseCase] The [GetTrendingReposUseCase] instance that are going to be used and is injected in this constructor
 */
@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val getTrendingReposUseCase: GetTrendingReposUseCase
) : ViewModel() {

    val trendingReposState: MutableLiveData<TrendingModel?> = MutableLiveData()
    val loadingState: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * This method is reponsible to execute the [GetTrendingReposUseCase] which will update [trendingReposState] state and
     * the [loadingState] state
     */
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