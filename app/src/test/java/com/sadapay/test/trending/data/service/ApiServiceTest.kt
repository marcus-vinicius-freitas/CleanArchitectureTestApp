@file:OptIn(ExperimentalCoroutinesApi::class)

package com.sadapay.test.trending.data.service

import junit.framework.TestCase.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceTest {

    private val mockWebServer = MockWebServer()

    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        mockWebServer.start()

        apiService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getTrendingRepositories returns expected data`() = runTest {
        // given
        val responseJson = """
            {
                "items": [
                    {
                        "name": "repo1",
                        "html_url": "https://github.com/repo1"
                    },
                    {
                        "name": "repo2",
                        "html_url": "https://github.com/repo2"
                    }
                ]
            }
        """.trimIndent()
        val response = MockResponse()
            .setResponseCode(200)
            .setBody(responseJson)
        mockWebServer.enqueue(response)

        // when
        val repositories = apiService.getTrendingRepositories().body()?.items

        // then
        assertNotNull(repositories)
        assertEquals(repositories?.size, 2)
        assertEquals(repositories?.get(0)?.name, "repo1")
        assertEquals(repositories?.get(1)?.name, "repo2")
    }

    @Test
    fun `getTrendingRepositories returns null for invalid response`() = runTest {
        // given
        val response = MockResponse()
            .setResponseCode(400)
            .setBody("Invalid JSON response")
        mockWebServer.enqueue(response)

        // when
        val repositories = apiService.getTrendingRepositories().body()?.items

        // then
        assertNull(repositories)
    }


}