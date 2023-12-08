package com.example.alpvisualprogramming.ui.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxScopeInstance.align
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
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
fun missionView() {

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
                    if (missionBox == true) {
                        LazyColumn() {

                        }
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp, top = 33.dp, bottom = 80.dp)
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
                        .padding(start = 30.dp, end = 30.dp)

                ) {
                    // Mission-Badge Switch ================================================================================================================
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
                                .shadow(7.dp,shape = RoundedCornerShape(8.dp))
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
                    }
                    // Mission-Badge Switch ================================================================================================================
                }
            }
            // Switch ================================================================================================================
            Box(
                modifier = Modifier
                    .zIndex(2f)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ){
                Row (
                    modifier = Modifier
                        .background(Color(0xFFF3F8FF)),
                ){
                    Spacer(modifier = Modifier.padding(6.dp))
                    bottomFooter(title = "To Do", picture = "to_do", Modifier.weight(1f).padding(top = 12.dp, bottom = 12.dp), Color.Black)
                    Spacer(modifier = Modifier.padding(6.dp))
                    bottomFooter(title = "Journal", picture = "journal", Modifier.weight(1f).padding(top = 12.dp, bottom = 12.dp), Color.LightGray)
                    Spacer(modifier = Modifier.padding(6.dp))
                    bottomFooter(title = "Mission", picture = "mission", Modifier.weight(1f).padding(top = 12.dp, bottom = 12.dp), Color.LightGray)
                    Spacer(modifier = Modifier.padding(6.dp))
                    bottomFooter(title = "Profile", picture = "profile", Modifier.weight(1f).padding(top = 12.dp, bottom = 12.dp), Color.LightGray)
                    Spacer(modifier = Modifier.padding(6.dp))
                }
            }



        }

//        Row (
//            modifier = Modifier
//        ){

//        }
    }

    // Container ================================================================================================================

}

@Composable
fun Badges(title: String, price: String, picture: String) {

    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp)
            .padding(start = 8.dp, end = 8.dp, top = 10.dp, bottom = 10.dp)
//            .shadow(1.dp, shape = RoundedCornerShape(12.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .weight(1f)
                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(12.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .weight(1.3f)
                    .padding(top = 7.dp, bottom = 3.dp),
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
                    .background(Color(0xFF3657C9)),
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
    }
}

@Composable
fun bottomFooter(title: String, picture: String, modifier: Modifier = Modifier, color: Color) {

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
                .clickable {
                    val toast = Toast.makeText(context, "$picture button", Toast.LENGTH_SHORT)
                    toast.show()
                },
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

@Composable
fun stringToDrawableId(context: Context, resourceName: String): Int {
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun Preview() {
    missionView()
}