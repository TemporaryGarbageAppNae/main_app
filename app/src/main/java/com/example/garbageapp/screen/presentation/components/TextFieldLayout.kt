package com.example.garbageapp.presentation.signin.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.example.garbageapp.screen.theme.ui.onError
import com.example.garbageapp.screen.theme.ui.onPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldLayout(
    text: String,
    value: String,
    isError: Boolean,
    errorMessage: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        isError = isError,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = White,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            errorIndicatorColor = Transparent,
            errorCursorColor = onError,
            errorLabelColor = onError,
            textColor = Black,
            cursorColor = Gray,
        ),
        shape = RoundedCornerShape(30.dp),
        placeholder = {
            Text(text = text)
        },
        modifier = Modifier
            .border(
                3.dp,
                shape = RoundedCornerShape(30.dp),
                color = if (isError) onError else onPrimary
            )
    )

    Spacer(modifier = Modifier.height(4.dp))

    if (isError) {
        Text(
            text = errorMessage,
            color = onError
        )
    }
}