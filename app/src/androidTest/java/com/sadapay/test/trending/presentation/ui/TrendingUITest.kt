@file:Suppress("OPT_IN_IS_NOT_ENABLED")
@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.presentation.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sadapay.test.MainActivity
import com.sadapay.test.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class TrendingUITest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun getTrendingRepoShouldShowRepoName() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("repo1")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("repo1")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("repo1")))
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }

    @Test
    fun getTrendingRepoShouldShowUserAvatar() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    hasDescendant(withId(R.id.userAvatar)),
                    isDisplayed(),
                )
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }

    @Test
    fun getTrendingRepoShouldShowUserName() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("user1")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("user2")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("user3")))
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }

    @Test
    fun getTrendingRepoShouldShowRepoDescription() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("description1")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("description2")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("description3")))
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }

    @Test
    fun getTrendingRepoShouldShowRepoLanguage() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("Python")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("Java")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("Kotlin")))
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }

    @Test
    fun getTrendingRepoShouldShowStarCount() = runTest {
        // Wait for the screen to load and verify that the list is displayed with the expected data
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("100")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("200")))
            )
        )
        onView(withId(R.id.repositoryList)).check(
            matches(
                allOf(
                    isDisplayed(),
                    hasDescendant(withText("300")))
            )
        )

        // Verify that the error message is not displayed
        onView(withId(R.id.errorMessage)).check(matches(not(isDisplayed())))
    }


}