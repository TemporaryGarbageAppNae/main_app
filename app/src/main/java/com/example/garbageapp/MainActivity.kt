package com.example.garbageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.garbageapp.screen.navigation.Navigation
import com.example.garbageapp.screen.theme.ui.GarbageAppTheme

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