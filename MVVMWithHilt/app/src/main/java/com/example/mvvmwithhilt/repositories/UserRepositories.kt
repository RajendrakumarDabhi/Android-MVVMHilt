package com.example.mvvmwithhilt.repositories

import com.example.mvvmwithhilt.models.ListUsersResponse
import com.example.mvvmwithhilt.network.api.ApiService
import javax.inject.Inject

class UserRepositories @Inject constructor(private val apiService: ApiService) {

    suspend fun getUsers(): ListUsersResponse {
      return  apiService.getUsers()
    }
}