package com.example.garbageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.garbageapp.navigation.Navigation
import com.example.garbageapp.ui.theme.GarbageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GarbageAppTheme {
                Navigation()
            }
        }
    }
}