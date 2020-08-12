package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.HiltApplication
import com.example.mvvmwithhilt.utils.Constants
import com.example.mvvmwithhilt.network.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(ActivityRetainedComponent::class)
@Module
class NetworkModule {

    @Provides
    fun provideBaseUrl(): String {
        return Constants.BASEURL
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logger)
        httpClient.callTimeout(60, TimeUnit.SECONDS)
        httpClient.connectTimeout(60, TimeUnit.SECONDS)
        httpClient.readTimeout(60, TimeUnit.SECONDS)
        httpClient.writeTimeout(60, TimeUnit.SECONDS)
        return httpClient.build()
    }

    @Provides
    fun provideGsonConvertorFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRetrofit(
        baseUrl: String,
        converterFactory: Converter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl(baseUrl)
        retrofitBuilder.addConverterFactory(converterFactory)
        retrofitBuilder.client(okHttpClient)
        return retrofitBuilder.build()
    }

    @Provides
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}