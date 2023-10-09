package com.example.garbageapp.screen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garbageapp.model.Orders
import com.example.garbageapp.screen.presentation.components.OrderLayout
import com.example.garbageapp.screen.theme.ui.primary

val orders = Orders().orders

@Composable
fun OrderStatusScreen(navController: NavController){
    Surface(color = primary) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 46.dp)
        ) {
            //NavBar
            
            Spacer(modifier = Modifier.height(20.dp))

            orders.forEach { order ->
                OrderLayout(
                    info = order
                )
            }
        }
    }
}