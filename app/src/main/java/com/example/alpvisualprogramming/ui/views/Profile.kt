package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Profile() {

//        Column(modifier = Modifier.fillMaxSize()) {
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight(0.5f)
//                    .fillMaxWidth()
//                    .background(Color(0xFF3960E5)),
//            ) {
//                Text(
//                    text = "Profile",
//                    textAlign = TextAlign.Center,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//            }
//
//            Card(
//                modifier = Modifier
//                    .padding(bottom = 20.dp)
//                    .fillMaxWidth()
//                    .background(Color.White)
//                    .clip(RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp))
//                    .border(2.dp, Color.Gray, RoundedCornerShape(32.dp, 32.dp, 32.dp, 32.dp)),
//            ) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//
//                    Text(text = "Richie Reuben", textAlign = TextAlign.Center)
//                    Text(text = "richie.reuben@example.com", textAlign = TextAlign.Center)
//                    Text(text = "My Badges", textAlign = TextAlign.Center)
//                    // Add your badges here
//                }
//            }
//        }
    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Profile_preview() {
    Profile();
}
