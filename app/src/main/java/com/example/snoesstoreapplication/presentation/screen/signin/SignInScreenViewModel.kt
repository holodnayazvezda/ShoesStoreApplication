package com.example.snoesstoreapplication.presentation.screen.signin

import android.app.AlertDialog
import android.content.Context
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.snoesstoreapplication.data.states.SignInState
import com.example.snoesstoreapplication.domain.usecase.SignInUsecase
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.launch

class SignInScreenViewModel(
    private val signInUsecase: SignInUsecase
) : ViewModel() {

    var state by mutableStateOf(SignInState())
        private set

    fun updatePassword(password: String) {
        state = state.copy(
            password = password
        )
    }

    fun updateEmail(email: String) {
        state = state.copy(
            email = email
        )
    }

    suspend fun loginUser(): Int {
        val supabase = createSupabaseClient(
            supabaseUrl = "https://ousyujdiywbomguyfhci.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im91c3l1amRpeXdib21ndXlmaGNpIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg3NzAyNDksImV4cCI6MjA1NDM0NjI0OX0.LH7585t7RHXeuMm-24C4b6zHxoUFgEbGpjv9xfWF8dE"
        ) {
            install(Auth)
            install(Postgrest)
        }
        var statusCode: Int = -1
        try {
            val data = supabase.auth.signUpWith(Email) {
                email = state.email.trim()
                password = state.password.trim()
            }
            statusCode = 0
        } catch (e: Exception) {
            statusCode = 1
        }
        return statusCode
    }

    fun buttonPressed(navController: NavHostController, context: Context) {
        val isOk = signInUsecase.checkEverything(state)
        if (!isOk) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder
                .setMessage("Одно из полей не заполнено, или email не сответсвует паттерну «name@domenname.ru»")
                .setTitle("Ошибка!")
                .setPositiveButton("Ok") { dialog, which ->

                }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        } else {
            viewModelScope.launch {
                loginUser()
            }
            navController.navigate("home")
        }
    }
}