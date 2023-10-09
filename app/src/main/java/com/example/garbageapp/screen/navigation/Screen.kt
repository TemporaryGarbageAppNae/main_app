package com.example.garbageapp.screen.navigation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object SignupScreen: Screen("signup_screen")
    object HomeScreen: Screen("home_screen")
    object ConfirmScreen: Screen("confirm_screen")
    object OrderStatusScreen: Screen("OrderStatusScreen")


    fun withArgs(vararg parameters: String): String {
        return buildString {
            append(route)
            parameters.forEach { param ->
                append("/$param")
            }
        }
    }
}
