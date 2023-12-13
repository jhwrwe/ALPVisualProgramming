package com.example.alpvisualprogramming.ui.views

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.alpvisualprogramming.R

@Composable
fun MissionView() {

    var missionBox: Boolean by rememberSaveable {
        mutableStateOf(true)
    }

    var badgeBox: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    // Container ================================================================================================================
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Box(
            modifier = Modifier
                .weight(9f)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
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
//                            .height(height = 235.dp)
                            .fillMaxHeight(0.31F)
                            .background(Color(0xFF3960E6)),
                        horizontalAlignment = Alignment.CenterHorizontally,
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
                                    painter = painterResource(id = R.drawable.coin_logo),
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
                    if (missionBox) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, top = 33.dp)
                        ) {
                            item {
                                Missions()
                            }
                            item {
                                Missions()
                            }
                            item {
                                Missions()
                            }
                            item {
                                Missions()
                            }
                        }
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp, end = 8.dp, top = 33.dp)
                        ) {
                            item {
                                Badges(
                                    title = "Bronze Medal",
                                    price = "1200",
                                    picture = "bronze_medal"
                                )
                            }
                            item {
                                Badges(
                                    title = "Silver Medal",
                                    price = "2400",
                                    picture = "silver_medal"
                                )
                            }
                            item {
                                Badges(title = "Gold Medal", price = "3600", picture = "gold_medal")
                            }
                            item {
                                Badges(title = "Sandglass", price = "5400", picture = "sandglass")
                            }
                            item {
                                Badges(title = "Sandglass", price = "5400", picture = "sandglass")
                            }


                        }
                    }
                    // Content ================================================================================================================
                }
            }


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
                        .padding(start = 30.dp, end = 30.dp)

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clip(RoundedCornerShape(8.dp))

                            .background(Color.White, shape = RoundedCornerShape(12.dp))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = 5.dp)
//                                .clip(RoundedCornerShape(8.dp))
                                .shadow(12.dp, shape = RoundedCornerShape(8.dp))
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
                                    colors = if (missionBox) {
                                        ButtonDefaults.buttonColors(
                                            containerColor = Color(
                                                0xFFFAB005
                                            )
                                        )
                                    } else {
                                        ButtonDefaults.buttonColors(containerColor = Color.White)
                                    }
                                ) {
                                    Text(
                                        text = "Mission",
                                        color = if (missionBox) {
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
                                    colors = if (badgeBox) {
                                        ButtonDefaults.buttonColors(
                                            containerColor = Color(
                                                0xFFFAB005
                                            )
                                        )
                                    } else {
                                        ButtonDefaults.buttonColors(containerColor = Color.White)
                                    }
                                ) {
                                    Text(
                                        text = "Badge",
                                        color = if (badgeBox) {
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
                    }
                }
            }
            // Switch ================================================================================================================
        }


        // Footer ================================================================================================================
        Footer()
        // Footer ================================================================================================================
    }
    // Container ================================================================================================================

}

@Composable
fun Missions() {
    Column  (
        modifier = Modifier
            .padding(top = 8.dp, bottom = 8.dp)
    ){
        Card (
            modifier = Modifier
                .height(100.dp)
                .fillMaxSize()
                .background(Color(0xFFF3F8FF), RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
                .shadow(3.dp, RoundedCornerShape(12.dp))
                .padding(start = 1.5.dp, end = 1.5.dp, top = 1.dp, bottom = 2.5.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F8FF)),
        ){
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFF3F8FF), RoundedCornerShape(12.dp))
                    .padding(start = 6.5.dp, end = 6.5.dp)
                    .clip(RoundedCornerShape(12.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Column (
                    modifier = Modifier
                        .weight(2f)
                        .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                        .background(Color(0xFFF3F8FF)),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.coin_logo),
                        contentDescription = "coin_logo",
                        modifier = Modifier
                            .size(28.dp)
                    )
                    Text(
                        text = "+30",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .graphicsLayer(scaleX = 1.2f)
                            .padding(2.dp)
                    )
                }
                Column (
                    modifier = Modifier
                        .weight(5f)
                        .fillMaxSize()
                        .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                        .background(Color(0xFFF3F8FF)),
                    verticalArrangement = Arrangement.Center,
                ){
                    Text(
                        text = "TASK_NAME",
                        fontSize = 20.sp,
                        color = Color(0xFF3F3F3F),
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 24.sp,

                        )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "blablablablablablablablablabla \nblablablablablablablablablabla",
                        fontSize = 12.sp,
                        color = Color(0xFFA0A4A7),
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 16.sp,

                        )
                }
                Column (
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxSize()
                        .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
                        .background(Color(0xFFF3F8FF)),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.Center
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(28.dp)
                            .background(Color(0xFF3960E6), RoundedCornerShape(8.dp))
                            .clickable {

                            },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "CLAIM",
                            fontSize = 13.sp,
                            color = Color.White,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "1/5",
                        fontSize = 16.sp,
                        lineHeight = 18.sp,
                        color = Color(0xFF3F3F3F),
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center

                    )

                }
            }
        }
    }
}

@Composable
fun Badges(title: String, price: String, picture: String) {

    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)
    var badgeBoolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(top = 10.dp, start = 4.dp, end = 4.dp)
            .width(160.dp)
            .height(210.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 4.dp, end = 4.dp, bottom = 2.dp)
                .shadow(6.dp, shape = RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF3F8FF))
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFFF3F8FF))
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(1.3f)
                        .padding(top = 9.dp, bottom = 3.dp),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = drawable),
                    contentDescription = "badge",
                    modifier = Modifier
                        .weight(6f)
                        .padding(bottom = 3.dp)
                        .size(100.dp),
                )
                Row(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .clickable { badgeBoolean = true }
                        .background(Color(0xFF3960E6)),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.coin_logo),
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
                            text = price,
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }


                }
            }

            if (badgeBoolean) {
                AlertDialog(
                    onDismissRequest = {},
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(8.dp),
                    title = {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(8.5f)
                            ) {
                                Spacer(modifier = Modifier.height(28.dp))
                                Text(
                                    text = "Are you sure you want to buy : \n'$title' badge?",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    lineHeight = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.weight(0.5f))
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = null,
                                    modifier = Modifier.clickable {
                                        badgeBoolean = false
                                    }
                                )
                            }
                        }
                    },
                    text = {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = drawable),
                                contentDescription = "badge",
                                modifier = Modifier
                                    .weight(6f)
                                    .background(Color(0xFFF3F8FF), RoundedCornerShape(12.dp))
                                    .padding(top = 5.dp, bottom = 5.dp)
                                    .size(100.dp),
                            )
                        }
                    },
                    confirmButton = {
                        Button(
                            onClick = {
                                badgeBoolean = false
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3960E6)),
                            modifier = Modifier
                                .fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Buy",
                                fontSize = 16.sp,
                                color = Color.White,
                                lineHeight = 18.sp
                            )
                        }
                    }
                )
            }
        }


    }
}

@Composable
fun BottomFooter(title: String, picture: String, modifier: Modifier = Modifier, color: Color) {

    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)

    Column(modifier = modifier) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .size(35.dp)
                .clickable {},
            colorFilter = ColorFilter.tint(color)
        )
        Text(
            text = title,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 2.dp),
            textAlign = TextAlign.Center,
            color = color,
            fontSize = 13.sp
        )
    }
}

@SuppressLint("DiscouragedApi")
@Composable
fun stringToDrawableId(context: Context, resourceName: String): Int {
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}



@Preview(showSystemUi = false, showBackground = true)
@Composable
fun Preview() {
    MissionView()
//    Missions()
}
