package com.example.garbageapp.screen.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garbageapp.R
import com.example.garbageapp.Util
import com.example.garbageapp.screen.presentation.components.ButtonLayout
import com.example.garbageapp.screen.presentation.components.TextFieldLayout
import com.example.garbageapp.screen.theme.ui.primary

@Composable
fun SignUpScreen(navController: NavController){

    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var isError_name by remember { mutableStateOf(false) }
    var isError_address by remember { mutableStateOf(false) }
    var errorMessage_name by remember { mutableStateOf("") }
    var errorMessage_address by remember { mutableStateOf("") }


    Surface( color = primary ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 46.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), 
                contentDescription = "Logo",
                modifier = Modifier.size(160.dp)
                )
                
                Spacer(modifier = Modifier.height(76.dp))
                
                TextFieldLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "whats_your_name_str"),
                    value = name, 
                    isError = isError_name,
                    errorMessage = errorMessage_name,
                    onValueChange = {
                        name = it
                    }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                TextFieldLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "whats_your_address_str"),
                    value = address,
                    isError = isError_address,
                    errorMessage = errorMessage_address,
                    onValueChange = {
                        address = it
                    }
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                ButtonLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "confirm_str"),
                    onClick = {
                        isError_name = false
                        errorMessage_name = ""
                        isError_address = false
                        errorMessage_address = ""

                        if (name.isEmpty()){
                            isError_name = true
                            errorMessage_name = Util.getJsonItemFromAsset(navController.context, "strings.json", "required_field_str")
                            return@ButtonLayout
                        }
                        if (address.isEmpty()){
                            isError_address = true
                            errorMessage_address = Util.getJsonItemFromAsset(navController.context, "strings.json", "required_field_str")
                            return@ButtonLayout
                        }
                        Toast.makeText(navController.context,"Conta criada, parabéns $name", Toast.LENGTH_SHORT).show()
                    })
            }

        }
    }
}