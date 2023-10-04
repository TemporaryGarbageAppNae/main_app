package com.example.garbageapp.screen.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration.Companion.Underline
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.garbageapp.R
import com.example.garbageapp.Util
import com.example.garbageapp.presentation.signin.components.ButtonLayout
import com.example.garbageapp.presentation.signin.components.TextFieldLayout
import com.example.garbageapp.screen.theme.ui.onSecondary
import com.example.garbageapp.screen.theme.ui.primary

@Composable
fun LoginScreen(navController: NavController) {

    var wallet by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Surface (color = primary) {
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
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo",
                    modifier = Modifier.size(160.dp)
                )

                Spacer(modifier = Modifier.height(76.dp))

                TextFieldLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "insert_wallet_str"),
                    value = wallet,
                    isError = isError,
                    errorMessage = errorMessage,
                    onValueChange = {
                        wallet = it
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))
                
                ButtonLayout(
                    text = Util.getJsonItemFromAsset(navController.context, "strings.json", "login_str"),
                    onClick = {
                        isError = false
                        errorMessage = ""

                        if (wallet.isEmpty()){
                            isError = true
                            errorMessage = Util.getJsonItemFromAsset(navController.context, "strings.json", "required_field_str")
                            return@ButtonLayout
                        }
                        Toast.makeText(
                            navController.context,
                            "Entrou! Com carteira: $wallet",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
            }

            Column ( verticalArrangement = Arrangement.Bottom) {
                Row {
                    Text(
                        text = Util.getJsonItemFromAsset(navController.context, "strings.json", "no_wallet?_str")
                    )
                    Text(
                        text = Util.getJsonItemFromAsset(navController.context, "strings.json", "create_wallet_str"),
                        color = onSecondary,
                        style = TextStyle(
                            textDecoration = Underline
                        )
                    )
                }
            }
        }
    }
}
