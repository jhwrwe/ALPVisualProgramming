package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@Composable
fun TestView() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (modifier = Modifier
            .fillMaxSize()
            .weight(9f)){

        }
        Column (modifier = Modifier
            .fillMaxWidth()
            .weight(1f)){
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .shadow(8.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .shadow(8.dp)
                        .background(Color(0xFFF3F8FF)),
                ) {
                    Spacer(modifier = Modifier.padding(6.dp))
                    BottomFooter(
                        title = "To Do",
                        picture = "to_do",
                        Modifier
                            .weight(1f)
                            .padding(top = 12.dp, bottom = 12.dp),
                        Color.Black,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    BottomFooter(
                        title = "Journal",
                        picture = "journal",
                        Modifier
                            .weight(1f)
                            .padding(top = 12.dp, bottom = 12.dp),
                        Color.Black,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    BottomFooter(
                        title = "Mission",
                        picture = "mission",
                        Modifier
                            .weight(1f)
                            .padding(top = 12.dp, bottom = 12.dp),
                        Color.Black,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                    BottomFooter(
                        title = "Profile",
                        picture = "profile",
                        Modifier
                            .weight(1f)
                            .padding(top = 12.dp, bottom = 12.dp),
                        Color.Black,
                        navController = navController
                    )
                    Spacer(modifier = Modifier.padding(6.dp))
                }
            }
        }
    }
}