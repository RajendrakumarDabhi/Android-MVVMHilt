package com.example.mvvmwithhilt.di

import com.example.mvvmwithhilt.repositories.UserRepositories
import com.example.mvvmwithhilt.usecase.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
class UsecaseModule{

    @Provides
    fun provideDataUsecase(userRepositories: UserRepositories): DataUseCase {
        return DataUseCase(userRepositories)
    }
}