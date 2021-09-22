package com.example.kotlinscopingfunctionswe

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {
    @GET("/api/users/{ID}")
    fun getUserDetails(@Path("ID") id: Int): retrofit2.Call<ResponseDTO>
}