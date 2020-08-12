package com.example.mvvmwithhilt.network.api

import com.example.mvvmwithhilt.models.ListUsersResponse
import retrofit2.http.GET

interface ApiService {
    @GET("/api/users?page=2")
    suspend fun getUsers(): ListUsersResponse
}