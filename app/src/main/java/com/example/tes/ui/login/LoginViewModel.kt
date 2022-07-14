package com.example.tes.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tes.data.model.User
import com.example.tes.domain.usecase.IUserUseCase
import com.example.tes.utils.vo.Resource
import kotlinx.coroutines.launch

class LoginViewModel (private val useCase: IUserUseCase) : ViewModel(){


    private val _loginResponse: MutableLiveData<User> = MutableLiveData()
    val loginResponse: LiveData<User>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = useCase.login(email, password)
    }


   fun saveAuthToken(authToken : String) = viewModelScope.launch {
        useCase.saveAccessTokens(authToken)
    }
}