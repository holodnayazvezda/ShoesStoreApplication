package com.example.snoesstoreapplication.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.snoesstoreapplication.R
import com.example.snoesstoreapplication.presentation.theme.AppAccent
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(1400)
        navController.navigate("signin")
    }
    Box(
        Modifier.fillMaxSize().background(AppAccent),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.onb),
            contentDescription = "",
            modifier = Modifier.size(130.dp)
        )
    }
}