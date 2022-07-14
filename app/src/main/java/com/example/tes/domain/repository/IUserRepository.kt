package com.example.tes.domain.repository

import com.example.tes.data.model.RegisterResponse
import com.example.tes.data.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    suspend fun addUser(email : String, username : String, password : String) : RegisterResponse
    suspend fun login(
        email: String,
        password: String
    ) : User
    suspend fun saveAccessTokens(accessToken: String)
}