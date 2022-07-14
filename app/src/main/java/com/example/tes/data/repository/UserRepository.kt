package com.example.tes.data.repository

import com.example.tes.data.model.RegisterResponse
import com.example.tes.data.model.User
import com.example.tes.data.preference.UserPreference
import com.example.tes.data.source.RemoteDataSource
import com.example.tes.domain.repository.IUserRepository

class UserRepository (
    private val remoteDataSource: RemoteDataSource,
    private val preference: UserPreference
) : IUserRepository {
    override suspend fun addUser(
        email: String,
        username: String,
        password: String
    ): RegisterResponse {
        return remoteDataSource.addUser(email, username, password)
    }

    override suspend fun login(email: String, password: String): User {
       return remoteDataSource.login(email, password)
    }

    override suspend fun saveAccessTokens(accessToken: String) {
        preference.saveAccessTokens(accessToken)
    }


}