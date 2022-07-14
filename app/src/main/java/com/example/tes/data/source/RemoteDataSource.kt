package com.example.tes.data.source

import com.example.tes.api.ApiServices
import com.example.tes.data.model.Register
import com.example.tes.data.model.RegisterResponse
import com.example.tes.data.model.User

class RemoteDataSource(private val apiServices : ApiServices) {

    suspend fun addUser(email : String, username : String, password : String) : RegisterResponse{
        return apiServices.addUser(email,username,password)
    }
    suspend fun login(
        email: String,
        password: String
    ) : User =
        apiServices.login(email, password)




}