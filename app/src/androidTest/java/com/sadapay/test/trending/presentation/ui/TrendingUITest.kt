@file:Suppress("OPT_IN_IS_NOT_ENABLED")
@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.presentation.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockito_kotlin.given
import com.sadapay.test.MainActivity
import com.sadapay.test.R
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.domain.models.TrendingModel
import com.sadapay.test.trending.domain.repositories.TrendingRepository
import com.sadapay.test.trending.domain.usecases.GetTrendingReposUseCaseImpl
import com.sadapay.test.trending.presentation.viewmodel.TrendingViewModel
import com.sadapay.test.utils.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TrendingUITest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun getTrendingRepoShouldBeSuccess() = runTest {
        // Set up the mock data and dependencies
        launchFragmentInHiltContainer<TrendingFragment> {
            // The ViewModel will be automatically injected by Hilt
        }

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

        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(matches(hasDescendant(withText("repo1"))))
        onView(withId(R.id.repositoryList)).check(matches(hasDescendant(withText("repo2"))))
        onView(withId(R.id.repositoryList)).check(matches(hasDescendant(withText("repo3"))))

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }


}