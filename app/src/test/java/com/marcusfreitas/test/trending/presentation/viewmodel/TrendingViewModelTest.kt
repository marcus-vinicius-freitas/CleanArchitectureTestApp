@file:Suppress("OPT_IN_IS_NOT_ENABLED")
@file:OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)

package com.marcusfreitas.test.trending.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import com.marcusfreitas.test.trending.domain.models.TrendingItemModel
import com.marcusfreitas.test.trending.domain.models.TrendingModel
import com.marcusfreitas.test.trending.domain.usecases.GetTrendingReposUseCase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TrendingViewModelTest {

    @get:Rule
    val testRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("Test")

    private lateinit var viewModel: TrendingViewModel
    private val getTrendingReposUseCase: GetTrendingReposUseCase = mock()

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = TrendingViewModel(getTrendingReposUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
        clearInvocations(getTrendingReposUseCase)
    }

    @Test
    fun `getTrendingRepos should return a valid TrendingModel`() = runTest {
        // given
        val mockRepos = listOf(
            TrendingItemModel("test1", null, null, null),
            TrendingItemModel("test2", null, null, null)
        )

        given(getTrendingReposUseCase.execute()).willReturn(
            TrendingModel(
                items = mockRepos
            )
        )

        // when
        viewModel.getTrendingRepos()

        // then
        verify(getTrendingReposUseCase).execute()
        assert(mockRepos == viewModel.trendingReposState.value?.items)
        assert(!viewModel.loadingState.value!!)
        reset(getTrendingReposUseCase)
    }

    @Test
    fun `getTrendingRepos should return null`() = runTest {
        // given
        given(getTrendingReposUseCase.execute()).willAnswer { throw Exception("test") }

        // when
        viewModel.getTrendingRepos()

        // then
        assert(viewModel.trendingReposState.value?.items == null)
        reset(getTrendingReposUseCase)
    }

}