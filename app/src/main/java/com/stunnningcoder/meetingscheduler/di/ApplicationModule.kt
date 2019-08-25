package com.stunnningcoder.meetingscheduler.di

import com.google.gson.Gson
import com.stunnningcoder.meetingscheduler.ApiInterface
import com.stunnningcoder.meetingscheduler.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by JS on 8/24/19.
 */

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getHttpLoggingInterceptor()).build()
    }

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun getApiService(retrofit: Retrofit) : ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }

}