package com.example.alpvisualprogramming.ui.views

//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.annotation.SuppressLint
import android.util.Log
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.viewmodel.SplashScreenVM
import com.example.alpvisualprogramming.ui.viewmodel.TodolistVM


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SplashScreenView( navController: NavController
) {
    val navigateToNextScreen by GlobalVariable.navigateToNextScreen.collectAsState()

    if (navigateToNextScreen) {
        GlobalVariable.resetNavigation()
        navController.navigate("destination_route") // Gantikan dengan route Anda
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xffECF4FF)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.to_do_list2___logo_removebg_preview),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(200.dp)
            )
        }
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {

    val navController = rememberNavController()
    SplashScreenView(navController)
}