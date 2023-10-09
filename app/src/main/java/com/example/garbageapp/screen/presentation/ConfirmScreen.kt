package com.example.garbageapp.screen.presentation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.garbageapp.Util
import com.example.garbageapp.screen.presentation.components.ButtonLayout
import com.example.garbageapp.screen.theme.ui.onError
import com.example.garbageapp.screen.theme.ui.onPrimary
import com.example.garbageapp.screen.theme.ui.primary

@Composable
fun ConfirmScreen(navController: NavController){
    var checked by remember { mutableStateOf(false) }
    Surface(color = primary) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 46.dp)
        ) {
            Box(modifier = Modifier
                .height(301.dp)
                .width(301.dp)
                .background(Color.White)
                .border(width = 6.dp, color = onPrimary, shape = RoundedCornerShape(2.dp))
            ){

            }

            Spacer(modifier = Modifier.height(10.dp))

            Box(modifier = Modifier
                .height(240.dp)
                .width(318.dp)
                .background(Color.White)
                .border(width = 6.dp, color = onPrimary, shape = RoundedCornerShape(2.dp))
            ){

            }


            Row( horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = {e -> checked = e},
                    colors = CheckboxDefaults.colors(Color.White),
                )
                Text(text = "Li e concordo com os termos de uso", fontSize = 12.sp) //TODO: add this string to json
            }
            
            ButtonLayout(
                text = Util.getJsonItemFromAsset(
                    navController.context,
                    "strings.json",
                    "confirm_str"
                ),
                onClick = {
                    if(!checked){
                        Toast.makeText(navController.context, "É necessário concordar com os termos", Toast.LENGTH_SHORT).show()
                        return@ButtonLayout
                    }
                    //TODO: Implement rest of operation here
                }
            )
        }
    }
}