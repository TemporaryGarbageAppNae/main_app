package com.example.garbageapp.screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.garbageapp.model.Orders
import com.example.garbageapp.screen.theme.ui.onError
import com.example.garbageapp.screen.theme.ui.onPrimary
import com.example.garbageapp.screen.theme.ui.primary
import com.example.garbageapp.screen.theme.ui.secondary
import java.lang.StringBuilder


@Composable
fun OrderLayout(
    info: Orders.OrderItem
){
    Box(
        modifier = Modifier
            .background(color = onPrimary)
            .height(100.dp)
            .width(327.dp)
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row() {
                Text(text = info.material + ":", color = Color.Black)
                Text(text = info.material, color = Color.Black)
                Spacer(modifier = Modifier.width(127.dp))
                Text(text = info.date)
            }
            Row() {
                Column ( modifier = Modifier.width(189.dp).height(47.dp)) {
                    Text(text = "Status" + ":", color = Color.Black) //TODO: ADD ALL THE STRINGS TO THE JSON
                    Box(
                        modifier = Modifier
                            .background(secondary)
                    )
                    {
                        Text(text = info.status, color = onPrimary)
                    }
                }
                Column( modifier = Modifier.width(189.dp).height(47.dp)) {
                    Text(text = "valor" + ":", color = Color.Black)
                    Box(
                        modifier = Modifier
                            .background(secondary)
                    )
                    {
                        Text(text = info.value.toString(), color = onPrimary)
                    }
                }
            }
        }
    }
}