package com.example.alpvisualprogramming

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import com.example.alpvisualprogramming.ui.ApplicationNavigation

class MainActivity : ComponentActivity() {

//    private lateinit var navController: NavController
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationNavigation()
        }
    }
}
