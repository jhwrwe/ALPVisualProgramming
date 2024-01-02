package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
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

@Composable
fun SignInPageView(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF3960E5)),
        verticalArrangement = Arrangement.SpaceBetween){
        Column (verticalArrangement = Arrangement.Center, modifier = Modifier
            .padding(top = 200.dp)
            .zIndex(2f)
            .padding(start = 20.dp)){
            Text(text = "Welcome to,",color = Color.White, fontSize = 35.sp, fontWeight = FontWeight.Bold)
            Text(text = "Application name", color = Color.White,fontSize = 35.sp, fontWeight = FontWeight.Bold)
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
            Text(text = "Be more productive with '...' and start", color = Color(0xFF3F3F3F), fontWeight = FontWeight.SemiBold,fontSize = 15.sp, modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 2.dp)
                .padding(top = 30.dp))
            Text(text = "writing your to-do list", color = Color(0xFF3F3F3F), fontWeight = FontWeight.SemiBold,fontSize = 15.sp, modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 2.dp)
                .padding(bottom = 10.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .padding(horizontal = 16.dp)
                ,colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),shape = RoundedCornerShape(8.dp)) {
                Text(text = "Sign In", fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }


            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Create Account",
                    color = Color(0xFF3F3F3F),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right,
                    textDecoration= TextDecoration.Underline,
                    modifier = Modifier.fillMaxWidth(0.85f)
                )
                Icon(
                    imageVector = Icons.Rounded.ArrowForward,
                    contentDescription = "Arrow Icon",
                    tint = Color(0xFF3F3F3F)
                )
            }

        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPagePreview(){
    val navController= rememberNavController()
    SignInPageView(navController)
}