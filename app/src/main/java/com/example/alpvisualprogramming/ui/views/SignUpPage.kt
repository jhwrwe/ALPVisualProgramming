package com.example.alpvisualprogramming.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.alpvisualprogramming.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SignUpPageView(){

    var username by rememberSaveable { mutableStateOf("") }
    var fullname by rememberSaveable { mutableStateOf("") }
    var phonenumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF3960E5))
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(0.dp, 0.dp, 0.dp, 55.dp))
                    .background(Color.White)
                    .height(160.dp)
            ){
                Row (
                    modifier = Modifier
                        .absolutePadding(top = 30.dp, left = 16.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "back"
                    )
                }

                Row(
                ){
                    Text(
                        text = "Create   ",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .absolutePadding(left = 20.dp)
                            .absolutePadding(top = 20.dp)
                    )
                }

                Row(
                ){
                    Text(
                        text = "Account",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .absolutePadding(left = 20.dp))
                }
            }
        }

        Row {
            Text(
                text = "Username",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 30.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(value = username,
                onValueChanged = { username = it },
                text = "Create a username",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.085F)
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Full Name",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(value = username,
                onValueChanged = { username = it },
                text = "Enter your full name",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1F)
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Phone Number",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(value = username,
                onValueChanged = { username = it },
                text = "Enter your phone number",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.12F)
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Email",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(value = username,
                onValueChanged = { username = it },
                text = "Enter your email",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15F)
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Password",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(value = username,
                onValueChanged = { username = it },
                text = "Create a password",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2F)
                    .padding(horizontal = 16.dp)
            )
        }

        Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .width(358.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(8.dp))
        {
            Text(
                text = "Sign Up",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
        }

        Row(
        ){
            Text(
                text = "Already have an account?",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 120.dp, top = 30.dp)
            )
        }

        Row(
        ){
            Text(
                text = "Sign In",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 175.dp, top = 28.dp)
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
){
OutlinedTextField(
    value = value,
    onValueChange = onValueChanged,
    label ={Text(text = text, color = Color.White)},
    keyboardOptions = keyboardOptions,
    modifier = modifier,
    shape = RoundedCornerShape(8.dp),
    colors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.White,
        focusedBorderColor = Color.White,
        unfocusedBorderColor = Color.White,

    )

)
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPagePreview(){
    SignUpPageView()
}

