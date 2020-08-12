package com.example.mvvmwithhilt.usecase

import com.example.mvvmwithhilt.models.BaseResponse
import com.example.mvvmwithhilt.models.ListUsersResponse
import com.example.mvvmwithhilt.models.User
import com.example.mvvmwithhilt.repositories.UserRepositories
import javax.inject.Inject

class DataUseCase @Inject constructor(private val userRepositories: UserRepositories) {
    suspend fun getUserList(): BaseResponse<ListUsersResponse> {
        val data = userRepositories.getUsers()

            if (data.data?.size!! >0) {
                return   BaseResponse.Success(data)
            } else {
                return   BaseResponse.Failed("Something went wrong")
            }

    }

}