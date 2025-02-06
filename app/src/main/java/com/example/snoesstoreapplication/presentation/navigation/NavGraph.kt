package com.example.snoesstoreapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snoesstoreapplication.domain.usecase.SignInUsecase
import com.example.snoesstoreapplication.presentation.screen.home.HomeScreen
import com.example.snoesstoreapplication.presentation.screen.signin.SignInScreen
import com.example.snoesstoreapplication.presentation.screen.signin.SignInScreenViewModel
import com.example.snoesstoreapplication.presentation.screen.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("signin") { SignInScreen(SignInScreenViewModel(SignInUsecase()), navController) }
        composable("home") { HomeScreen(navController) }
    }
}