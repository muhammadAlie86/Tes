package com.example.tes.api

import com.example.tes.data.model.Register
import com.example.tes.data.model.RegisterResponse
import com.example.tes.data.model.User
import retrofit2.http.*


interface ApiServices {

    @FormUrlEncoded
    @POST("/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): User

    @FormUrlEncoded
    @POST("/register")
    suspend fun addUser(
        @Field("email") email : String,
        @Field("username") username : String,
        @Field("password") password : String,
    ) : RegisterResponse



}