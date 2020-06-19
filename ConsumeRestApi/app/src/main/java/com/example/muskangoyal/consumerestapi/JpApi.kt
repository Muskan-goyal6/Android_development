package com.example.muskangoyal.consumerestapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JpApi {

    @GET("/users")
    fun getUsers (): Call<Array<User>>
    @GET("/users/{userId}")
    fun getUserById(
            @Path("userId") userId: Int
    ): Call<User>



    @GET("/posts")
    fun getPosts(): Call<Array<Post>>
}