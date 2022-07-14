package com.example.tes.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudsample.utils.extension.Event
import com.example.tes.R
import com.example.tes.data.source.RemoteDataSource
import com.example.tes.domain.usecase.IUserUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterViewModel (private val useCase: IUserUseCase): ViewModel() {

    private val _snackBarText = MutableLiveData<Event<Int>>()
    val snackBarText: LiveData<Event<Int>> = _snackBarText

    private val _isNavigateTo = MutableLiveData<Boolean>()
    val isNavigateTo : LiveData<Boolean> = _isNavigateTo

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)


    fun postUserClick(email : String, username : String, password : String
    ) {
        when {
            email.isEmpty() -> {
                _snackBarText.value = Event(R.string.enter_your_email)
                _isNavigateTo.value = false
                return
            }
            username.isEmpty() -> {
                _snackBarText.value = Event(R.string.enter_your_username)
                _isNavigateTo.value = false
                return
            }
            password.isEmpty() -> {
                _snackBarText.value = Event(R.string.enter_your_password)
                _isNavigateTo.value = false
                return
            }
            else -> {

                uiScope.launch {
                    useCase.addUser(
                        email = email,
                        username = username,
                        password = password
                    )
                    _snackBarText.value = Event(R.string.success)
                    _isNavigateTo.value = true
                    return@launch
                }
            }
        }
    }
}