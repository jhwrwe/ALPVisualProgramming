package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.alpvisualprogramming.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpPageView(){
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
                            .absolutePadding(left = 16.dp)
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
                            .absolutePadding(left = 16.dp))
                }
            }
        }

        Row {
            Text(
                text = "Username",
                fontSize = 15.sp,
                color = Color.White,
                modifier = Modifier
                    .absolutePadding(top = 40.dp, left = 16.dp)
            )
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 3.dp)
                .background(Color(0xFF3960E5), shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
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
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 3.dp)
                .background(Color(0xFF3960E5), shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
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
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 3.dp)
                .background(Color(0xFF3960E5), shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
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
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 3.dp)
                .background(Color(0xFF3960E5), shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
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
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 3.dp)
                .background(Color(0xFF3960E5), shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
        }

        Row {
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .absolutePadding(top = 30.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(40.dp)
        ){
            Text(
                text = "Sign Up",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .absolutePadding(left = 145.dp, top = 6.dp)
            )
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPagePreview(){
    SignUpPageView()
}

