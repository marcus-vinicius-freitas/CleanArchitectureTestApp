@file:Suppress("OPT_IN_IS_NOT_ENABLED")
@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.presentation.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockito_kotlin.given
import com.sadapay.test.MainActivity
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.domain.repositories.TrendingRepository
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
import com.sadapay.test.trending.presentation.viewmodel.TrendingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@RunWith(AndroidJUnit4::class)
class TrendingUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun getTrendingRepoShouldBeSuccess() = runTest {
        // Set up the mock data and dependencies
        val mockRepository = mock(TrendingRepository::class.java)
        val mockUseCase = GetTrendingReposUseCaseImpl(mockRepository)

        val mockData = listOf(
            TrendingItemModel("repo1", null, null, null),
            TrendingItemModel("repo2", null, null, null),
            TrendingItemModel("repo3", null, null, null)
        )

        given(mockRepository.getTrendingRepos()).willReturn(TrendingModel(
            mockData
        ))

        // Launch the screen with the mocked data
        composeTestRule.setContent {
            TrendingScreen(viewModel = TrendingViewModel(mockUseCase))
        }

        // Wait for the screen to load and verify that the list is displayed with the expected data
        composeTestRule.onNodeWithText("repo1").assertIsDisplayed()
        composeTestRule.onNodeWithText("repo2").assertIsDisplayed()
        composeTestRule.onNodeWithText("repo3").assertIsDisplayed()

        // Verify that the error message is not displayed
        composeTestRule.onNodeWithText("Something went wrong").assertDoesNotExist()
    }


}