package com.example.garbageapp.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.garbageapp.screen.presentation.ConfirmScreen
import com.example.garbageapp.screen.presentation.LoginScreen
import com.example.garbageapp.screen.presentation.OrderStatusScreen
import com.example.garbageapp.screen.presentation.SignUpScreen

//TODO: figure out navigation
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ConfirmScreen.route){
        composable(route = Screen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(route = Screen.SignupScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.HomeScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.OrderStatusScreen.route){
            OrderStatusScreen(navController = navController)
        }
        composable(route = Screen.ConfirmScreen.route){
            ConfirmScreen(navController = navController)
        }
    }
}