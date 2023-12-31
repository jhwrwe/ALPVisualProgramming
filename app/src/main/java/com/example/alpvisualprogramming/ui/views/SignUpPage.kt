package com.example.alpvisualprogramming.ui.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.viewmodel.UserVM

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun SignUpPageView(userVM: UserVM, navController: NavController) {
    val context = LocalContext.current
    var username by rememberSaveable { mutableStateOf("") }
    var fullname by rememberSaveable { mutableStateOf("") }
    var phonenumber by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var profile_photo_path by rememberSaveable { mutableStateOf("") }

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
            ) {
                Row(
                    modifier = Modifier
                        .absolutePadding(top = 30.dp, left = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = "back",
                        modifier = Modifier
                            .clickable {
                                navController.navigate(NavGraph.LoginPageRoute)
                            }
                    )
                }

                Row {
                    Text(
                        text = "Create   ",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .absolutePadding(left = 20.dp)
                            .absolutePadding(top = 20.dp)
                    )
                }

                Row {
                    Text(
                        text = "Account",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .absolutePadding(left = 20.dp)
                    )
                }
            }
        }

        Row {
            Text(
                text = "Username",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 30.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(
                value = username,
                onValueChanged = { username = it },
                text = "Create a username",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Full Name",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(
                value = fullname,
                onValueChanged = { fullname = it },
                text = "Enter your full name",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Phone Number",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(
                value = phonenumber,
                onValueChanged = { phonenumber = it },
                text = "Enter your phone number",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Email",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(
                value = email,
                onValueChanged = { email = it },
                text = "Enter your email",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Row {
            Text(
                text = "Password",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 10.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField(
                value = password,
                onValueChanged = { password = it },
                text = "Create a password",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        Button(
            onClick = {
                userVM.ButtonRegister(
                    username,
                    fullname,
                    phonenumber,
                    email,
                    profile_photo_path,
                    password,
                    context,
                    navController
                )
            },
            enabled = username.isNotEmpty() && fullname.isNotEmpty() && phonenumber.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty(),
            modifier = Modifier
                .width(358.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(8.dp)
        )
        {
            Text(
                text = "Sign Up",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }

        Row {
            Text(
                text = "Already have an account?",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 120.dp, top = 20.dp)
            )
        }

        Row {
            Text(
                text = "Sign In",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 175.dp, top = 28.dp)
                    .clickable {
                        navController.navigate(NavGraph.SignInPageRoute)
                    }
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
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = {
            Text(
                text = text,
                color = Color.White,
                modifier = Modifier.padding(start = 3.dp),
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        )
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPagePreview() {
    val navController = rememberNavController()
    if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
        val userVM: UserVM = viewModel()
        SignUpPageView(
            userVM = userVM,
            navController = navController,
        )
    }
}

