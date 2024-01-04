package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.example.alpvisualprogramming.ui.NavGraph
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.Data.DataStoreManager
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.viewmodel.UserVM

@Composable
fun LogInPageView(
    loginViewModel: UserVM,
    navController: NavController,
    dataStore: DataStoreManager
) {

    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current;

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
                        contentDescription = "back"
                    )
                }

                Row(
                ) {
                    Text(
                        text = "Welcome",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .absolutePadding(left = 20.dp)
                            .absolutePadding(top = 20.dp)
                    )
                }

                Row(
                ) {
                    Text(
                        text = "Back!",
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
                text = "username",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 75.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField1(
                value = username,
                onValueChanged = { username = it },
                text = "Enter your username",
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
                text = "Password",
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 25.dp, left = 16.dp)
            )
        }
        Column {
            CustomTextField1(
                value = password,
                onValueChanged = { password = it },
                text = "Enter your password",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.125F)
                    .padding(horizontal = 16.dp),
            )
        }
        Row(
        ) {
            Box(
                modifier = Modifier
                    .absolutePadding(top = 18.dp, left = 25.dp)
                    .background(Color.White, shape = RoundedCornerShape(3.dp))
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(3.dp)
                    )
                    .height(17.dp)
                    .width(17.dp)
            )
            Text(
                text = "Remember me",
                color = Color.White,
                modifier = Modifier
                    .padding(18.dp)
            )
        }

        Button(
            onClick = {
                loginViewModel.ButtonLogin(username, password, context, navController, dataStore)
            },
            modifier = Modifier
                .width(358.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(8.dp)
        )
        {
            Text(
                text = "Sign In",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }

        Row(
        ) {
            Text(
                text = "Forgot Password?",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 260.dp, top = 10.dp)

            )
        }

        Row(
        )
        {
            Text(
                text = "Don't have an account?",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 130.dp, top = 74.dp)
            )
        }

        Row(
        ) {
            Text(
                text = "Sign Up",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier
                    .absolutePadding(left = 175.dp, top = 28.dp)
                    .clickable {
                        navController.navigate(NavGraph.SignUpPage)
                    }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField1(
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
            .height(52.dp),
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
fun LogInPagePreview() {
    val navController = rememberNavController()
    val dataStore = DataStoreManager(LocalContext.current)
    if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
        val loginViewModel: UserVM = viewModel()
        LogInPageView(
            loginViewModel = loginViewModel,
            navController = navController,
            dataStore = dataStore
        )
    }
}

