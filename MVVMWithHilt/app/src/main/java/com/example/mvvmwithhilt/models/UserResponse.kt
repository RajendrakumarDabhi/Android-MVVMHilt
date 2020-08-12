package com.example.mvvmwithhilt.models

import com.google.gson.annotations.SerializedName

data class ListUsersResponse(
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("data")
    val data: List<User>?,
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0
)