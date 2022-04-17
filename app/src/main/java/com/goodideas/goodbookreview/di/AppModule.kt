package com.goodideas.goodbookreview.di

import com.goodideas.goodbookreview.data.remote.GoodReviewApi
import com.goodideas.goodbookreview.data.repository.GoodReviewRepositoryImpl
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFunMarketingApi(): GoodReviewApi {

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GoodReviewApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: GoodReviewApi): GoodReviewRepository {
        return GoodReviewRepositoryImpl(api)
    }
}