package com.example.tes.di

import com.example.tes.domain.usecase.IUserUseCase
import com.example.tes.domain.usecase.UserIterator
import com.example.tes.ui.login.LoginViewModel
import com.example.tes.ui.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<IUserUseCase> { UserIterator(get()) }
}

val viewModelModule = module {
    viewModel { RegisterViewModel(get())}
    viewModel { LoginViewModel(get())}
}