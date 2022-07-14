package com.example.tes.domain.usecase

import com.example.tes.data.model.RegisterResponse
import com.example.tes.data.model.User
import com.example.tes.domain.repository.IUserRepository
import com.example.tes.utils.vo.Resource
import kotlinx.coroutines.flow.Flow

class UserIterator (private val iUserRepository : IUserRepository) : IUserUseCase{
    override suspend fun addUser(
        email: String,
        username: String,
        password: String
    ): RegisterResponse {
        return iUserRepository.addUser(email, username, password)
    }

    override suspend fun login(email: String, password: String): User {
        return iUserRepository.login(email, password)
    }

    override suspend fun saveAccessTokens(accessToken: String) {
        return iUserRepository.saveAccessTokens(accessToken)
    }


}