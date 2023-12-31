package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.theme.poppinsFamily

@Composable
fun SignInPageView(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3960E5)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center, modifier = Modifier
                .padding(top = 200.dp)
                .zIndex(2f)
                .padding(start = 20.dp)
        ) {
            Text(
                text = "Welcome to,\nApplication name",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFamily,
//                lineHeight = 25.sp
            )
//            Text(
//                text = "Application name",
//                color = Color.White,
//                fontSize = 35.sp,
//                fontWeight = FontWeight.SemiBold,
//                fontFamily = poppinsFamily,
////                lineHeight = 25.sp
//            )
        }
        Card(
            modifier = Modifier
                .zIndex(2f)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(0.dp, 64.dp, 0.dp, 0.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(0.dp, 64.dp, 0.dp, 0.dp)),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Text(
                text = "Be more productive with '...' and start \nwriting your to-do list",
                color = Color(0xFF3F3F3F),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(vertical = 2.dp)
                    .padding(top = 30.dp)
            )
//            Text(
//                text = "writing your to-do list",
//                color = Color(0xFF3F3F3F),
//                fontWeight = FontWeight.Medium,
//                fontSize = 15.sp,
//                fontFamily = poppinsFamily,
//                modifier = Modifier
//                    .padding(horizontal = 20.dp)
//                    .padding(vertical = 2.dp)
//                    .padding(bottom = 10.dp)
//            )
            Button(
                onClick = {
                    if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
                        navController.navigate(NavGraph.LoginPageRoute)
                    } else {
                        navController.navigate(NavGraph.HomePageRoute)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    fontFamily = poppinsFamily,
                    textAlign = TextAlign.Center
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.clickable {
                        navController.navigate(NavGraph.SignUpPage)
                    },
                ) {
                    Text(
                        text = "Create Account",
                        color = Color(0xFF3F3F3F),
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFamily,
                        textAlign = TextAlign.Right,
                        textDecoration = TextDecoration.Underline,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = "Arrow Icon",
                        tint = Color(0xFF3F3F3F),
                        modifier = Modifier
                            .graphicsLayer(scaleY = 0.8f)
                    )
                }
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPagePreview() {
    val navController = rememberNavController()
    SignInPageView(navController)
}