package com.example.garbageapp.screen.presentation.components


import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.garbageapp.screen.theme.ui.onError
import com.example.garbageapp.screen.theme.ui.onPrimary
import com.example.garbageapp.screen.theme.ui.secondary


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
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            errorCursorColor = onError,
            errorLabelColor = onError,
            textColor = Color.Black,
            cursorColor = Color.Gray,
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownFieldLayout(
    text: String,
    items: List<String>,
    isError: Boolean,
    errorMessage: String,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = true }
    ) {
        TextField(
            value = selectedItem,
            onValueChange = {},
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                errorCursorColor = onError,
                errorLabelColor = onError,
                textColor = Color.Black,
                cursorColor = Color.Gray,
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
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    }
                )
            }
        }
    }
    if (isError) {
        Text(
            text = errorMessage,
            color = onError
        )
    }
}

@Composable
fun ButtonLayout(
    text: String,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = secondary,
            contentColor = Color.Black
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

