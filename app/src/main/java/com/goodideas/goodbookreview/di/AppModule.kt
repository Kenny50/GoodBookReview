package com.goodideas.goodbookreview.di

import android.content.Context
import com.goodideas.goodbookreview.BuildConfig
import com.goodideas.goodbookreview.data.remote.GoodReviewApi
import com.goodideas.goodbookreview.data.repository.GoodReviewRepositoryImpl
import com.goodideas.goodbookreview.domain.repository.GoodReviewRepository
import com.goodideas.goodbookreview.util.DataStoreManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFunMarketingApi(): GoodReviewApi {

        val okHttpClient = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                this.addInterceptor(interceptor = loggingInterceptor)
            }
        }.build()

        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(GoodReviewApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStoreManager: DataStoreManager,
        api: GoodReviewApi
    ): GoodReviewRepository {
        return GoodReviewRepositoryImpl(dataStoreManager, api)
    }

    @Provides
    @Singleton
    fun provideDataStoreManager(@ApplicationContext context: Context): DataStoreManager {
        return DataStoreManager(context)
    }
}