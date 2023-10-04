package com.example.garbageapp.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.garbageapp.screen.presentation.LoginScreen
import com.example.garbageapp.screen.presentation.SignUpScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.LoginScreen.route){
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignupScreen.route){
            SignUpScreen(navController = navController)
        }
    }
}