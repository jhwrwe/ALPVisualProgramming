package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInPageView(){
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF3960E5)),
        verticalArrangement = Arrangement.SpaceBetween){
        Column (verticalArrangement = Arrangement.Center, modifier = Modifier.padding(top=200.dp)){
            Text(text = "Welcome to,",color = Color.White, fontSize = 40.sp, fontWeight = FontWeight.Bold)
            Text(text = "Application name", color = Color.White,fontSize = 40.sp, fontWeight = FontWeight.Bold)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .clip(RoundedCornerShape(0.dp, 64.dp, 0.dp, 0.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(0.dp, 64.dp, 0.dp, 0.dp))
        ) {
            Text(text = "Be more productive with '...' and start", color = Color(0xFF3F3F3F), fontWeight = FontWeight.SemiBold,fontSize = 15.sp, modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 2.dp))
            Text(text = "writing your to-do list", color = Color(0xFF3F3F3F), fontWeight = FontWeight.SemiBold,fontSize = 15.sp, modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(vertical = 2.dp))
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),colors = ButtonDefaults.buttonColors(Color(0xFF3960E5))) {
                Text(text = "Sign In", fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }
4

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)){
                Text(text = "Create Account",color = Color(0xFF3F3F3F), fontWeight = FontWeight.Bold, textAlign = TextAlign.Right,modifier = Modifier.fillMaxWidth())
                Icon(Icons.Rounded.ArrowForward, contentDescription = "Back")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPagePreview(){
    SignInPageView()
}