package com.example.mvvmwithhilt.models

import com.google.gson.annotations.SerializedName

/*
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
*/

//@Entity(tableName = "User")
data class User(
    @SerializedName("last_name")
    val last_name: String = "",
    @SerializedName("id")
    //   @PrimaryKey
    val id: Int = 0,
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("first_name")
    val first_name: String = "",
    @SerializedName("email")
    val email: String = ""
)


