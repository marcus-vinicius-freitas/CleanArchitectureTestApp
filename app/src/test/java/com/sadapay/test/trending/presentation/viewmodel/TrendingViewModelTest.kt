@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.presentation.viewmodel

import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
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
    fun `getTrendingRepos should return a valid result`() = runTest {
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

}