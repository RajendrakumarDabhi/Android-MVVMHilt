package com.example.mvvmwithhilt.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmwithhilt.models.BaseResponse
import com.example.mvvmwithhilt.models.ListUsersResponse
import com.example.mvvmwithhilt.models.User
import com.example.mvvmwithhilt.usecase.DataUseCase

class MainViewModel @ViewModelInject constructor(private val useCase: DataUseCase) : ViewModel() {

    fun getUserList(): LiveData<BaseResponse<ListUsersResponse>> {
        return liveData<BaseResponse<ListUsersResponse>> {
            emit(BaseResponse.Loading())
            emit(useCase.getUserList())
        }

    }
}