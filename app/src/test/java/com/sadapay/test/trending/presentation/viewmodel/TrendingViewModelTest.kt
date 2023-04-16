@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.presentation.viewmodel

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class TrendingViewModelTest {

    private lateinit var viewModel: TrendingViewModel

    @Before
    fun setUp() {
        viewModel = TrendingViewModel()
    }

    @Test
    fun `getTrendingRepos should return a not null result`() = runTest {
        // when
        viewModel.getTrendingRepos()

        // then
        assertNotNull(viewModel.trendingReposState.value)
    }

    @Test
    fun `getTrendingRepos should return null`() = runTest {
        // when
        viewModel.getTrendingRepos()

        // then
        assertNull(viewModel.trendingReposState.value)
    }

    @Test
    fun `getTrendingRepos should return a valid TrendingModel`() = runTest {
        // when
        viewModel.getTrendingRepos()

        // then
        assert(viewModel.trendingReposState.value?.items?.first()?.name == "test")
    }

}