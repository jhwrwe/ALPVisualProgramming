package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.alpvisualprogramming.R

@Composable
fun missionView() {

    var missionBox: Boolean by rememberSaveable {
        mutableStateOf(true)
    }

    var badgeBox: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    // Container ================================================================================================================
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        // Header + Content ================================================================================================================
        Box(
            modifier = Modifier
                .zIndex(1f)
                .fillMaxSize()

        ) {
            // Header ================================================================================================================
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 12.dp
                            )
                        )
                        .height(height = 235.dp)
                        .background(Color(0xFF3657C9)),
                    horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center,
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Daily Mission",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "12345",
                            color = Color.White,
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.x),
                                contentDescription = "Coin Icon",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Coins",
                                color = Color.White,
                                fontSize = 20.sp,
                            )
                        }

                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Do your tasks and get more coins!",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }


                }
                // Header ================================================================================================================

                // Content ================================================================================================================
                LazyColumn() {

                }
                // Content ================================================================================================================
            }
        }
        // Header + Content ================================================================================================================


        // Switch ================================================================================================================
        Box(
            modifier = Modifier
                .zIndex(2f)
                .fillMaxWidth()
                .padding(top = 210.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                // Mission-Badge Switch ================================================================================================================
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 30.dp, end = 30.dp)
                        .background(Color.White)
                        .shadow(2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Button(
                            onClick = {
                                missionBox = true
                                badgeBox = false
                            },
                            shape = RectangleShape,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            colors = if (missionBox == true) {
                                ButtonDefaults.buttonColors(containerColor = Color(0xFFFAB005))
                            } else {
                                ButtonDefaults.buttonColors(containerColor = Color.White)
                            }
                        ) {
                            Text(
                                text = "Mission",
                                color = if (missionBox == true) {
                                    Color.White
                                } else {
                                    Color.Black
                                },
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Button(
                            onClick = {
                                badgeBox = true
                                missionBox = false
                            },
                            shape = RectangleShape,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            colors = if (badgeBox == true) {
                                ButtonDefaults.buttonColors(containerColor = Color(0xFFFAB005))
                            } else {
                                ButtonDefaults.buttonColors(containerColor = Color.White)
                            }
                        ) {
                            Text(
                                text = "Badge",
                                color = if (badgeBox == true) {
                                    Color.White
                                } else {
                                    Color.Black
                                },
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                }
                // Mission-Badge Switch ================================================================================================================
            }
        }
        // Switch ================================================================================================================

    }
    // Container ================================================================================================================

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Preview() {
    missionView()
}