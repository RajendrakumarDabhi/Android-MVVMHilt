package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.network.api.ApiService
import com.example.mvvmwithhilt.repositories.UserRepositories
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
class RepositoriesModule{

    @Provides
    fun getUserRepositories(apiService: ApiService): UserRepositories {
        return UserRepositories(apiService)
    }
}