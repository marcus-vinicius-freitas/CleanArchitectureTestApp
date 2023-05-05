package com.sadapay.test.trending.presentation.di

import com.google.gson.GsonBuilder
import com.sadapay.test.trending.data.mappers.TrendingMapper
import com.sadapay.test.trending.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder().apply {
            this.readTimeout(1, TimeUnit.MINUTES)
            this.connectTimeout(1, TimeUnit.MINUTES)
        }
    }

    @Singleton
    @Provides
    fun providesApiService(clientBuilder: OkHttpClient.Builder): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(clientBuilder.build())
            .build()
            .create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesMapper(): TrendingMapper {
        return TrendingMapper()
    }

}