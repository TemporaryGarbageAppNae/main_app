package com.example.garbageapp.presentation.signin.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import com.example.garbageapp.screen.theme.ui.onPrimary
import com.example.garbageapp.screen.theme.ui.secondary

@Composable
fun ButtonLayout(
    text: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = secondary,
            contentColor = Black
        ),
        onClick = {
            onClick()
        },
        modifier = Modifier
            .border(3.dp, onPrimary, RoundedCornerShape(30.dp))
            .width(158.dp)
    ) {
        Text(text = text)
    }
}