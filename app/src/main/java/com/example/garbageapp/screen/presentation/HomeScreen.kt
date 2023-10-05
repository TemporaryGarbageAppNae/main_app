package com.example.garbageapp.screen.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garbageapp.Util
import com.example.garbageapp.presentation.signin.components.ButtonLayout
import com.example.garbageapp.presentation.signin.components.TextFieldLayout
import com.example.garbageapp.screen.presentation.components.DropdownFieldLayout
import com.example.garbageapp.screen.theme.ui.primary




@Composable
fun HomeScreen(navController: NavController){


    var waste_type by remember { mutableStateOf("") }
    var isError_waste by remember { mutableStateOf(false) }
    var errorMessage_waste by remember { mutableStateOf("") }

    var quantity by remember { mutableStateOf("") }
    var isError_quantity by remember { mutableStateOf(false) }
    var errorMessage_quantity by remember { mutableStateOf("") }

    fun HandleError(){
        isError_waste = waste_type.isEmpty()
        isError_quantity = quantity.isEmpty()
        errorMessage_waste = when(isError_waste) {
            true -> Util.getJsonItemFromAsset(navController.context, "strings.json", "waste_error_str")
            false -> ""
        }
        errorMessage_quantity = when(isError_quantity) {
            true -> Util.getJsonItemFromAsset(navController.context, "strings.json", "quantity_error_str")
            false -> ""
        }
    }

    Surface (color = primary) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 46.dp)
        ) {
            //TODO: navigation bar
            
            Spacer(modifier = Modifier.height(160.dp))

            DropdownFieldLayout(
                text = Util.getJsonItemFromAsset(navController.context, "strings.json", "waste_type_str"),
                items = Util.getJsonItemFromAssetAsArray(navController.context, "strings.json", "waste_types_strs"), //TODO: implement this method
                selectedItem = waste_type,
                isError = isError_waste,
                errorMessage = errorMessage_waste,
                onItemSelected = {
                    waste_type = it
                }
            )
            
            Spacer(modifier = Modifier.height(16.dp))

            TextFieldLayout(
                text = Util.getJsonItemFromAsset(navController.context,"strings.json","quantity_str"),
                value = quantity,
                isError = isError_quantity,
                errorMessage = errorMessage_quantity,
                onValueChange = {
                    quantity = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

           /*
            InsertImgLayout( //TODO: implement insertImgLayout component
                
            )
            */

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                ButtonLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "offer_str"),
                    onClick = {
                        HandleError()
                    }
                )
                ButtonLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "give_away_str"),
                    onClick = {
                        HandleError()
                    }
                )
            }

            Column( verticalArrangement = Arrangement.Bottom ) {
                //BottomNavLayout() //TODO: implement bottomNavLayout component
            }

        }
    }
}
