package com.example.snoesstoreapplication.domain.usecase

import com.example.snoesstoreapplication.data.states.SignInState

class SignInUsecase {
    private fun checkEmail(email: String): Boolean {
        val emailRegex = "^[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$".toRegex()
        return emailRegex.matches(email)
    }

    private fun checkPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun checkEverything(signInState: SignInState): Boolean {
        return checkEmail(signInState.email) && checkPassword(signInState.password)
    }

}