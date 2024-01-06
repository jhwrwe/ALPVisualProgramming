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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.ui.viewmodel.BadgeVM
import com.example.alpvisualprogramming.ui.viewmodel.MissionVM
import com.example.alpvisualprogramming.ui.viewmodel.UserVM

@Composable
fun Profile(
    navController: NavController,
    userViewModel: UserVM,
    missionViewModel: MissionVM,
    badgeViewModel: BadgeVM,
) {
    userViewModel.getUser()
    val user by GlobalVariable.usera.collectAsState()
    val uBadges by GlobalVariable.uBadges.collectAsState()
    val missions by GlobalVariable.missions.collectAsState()
    Column(modifier = Modifier.fillMaxSize(1F)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(9f)
        ) {
            Box(
                modifier = Modifier
                    .zIndex(2f)
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.31F)
                        .zIndex(1f)
                        .background(color = Color(0xFF3960E5)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Profile",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(20.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .zIndex(2f)
                        .fillMaxWidth()
                        .fillMaxHeight(0.6F)
                        .padding(top = 60.dp)
                        .shadow(
                            elevation = 17.dp,
                            shape = RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.9F)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp))
                            .border(
                                0.dp,
                                Color.Gray,
                                RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)
                            )
                            .background(Color.White)
                            .padding(20.dp),
                        colors = CardDefaults.cardColors(Color.White),

                        ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
//                   Image(painter = , contentDescription = )
                            }
                            Column(
                                Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text =
                                    if (user.fullname.isNotEmpty()) {
                                        user.fullname
                                    } else {
                                        "ERROR FULLNAME"
                                    },
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 22.sp,
                                    color = Color(0xFF3F3F3F)
                                )
                                Text(
                                    text =
                                    if (user.email.isNotEmpty()) {
                                        user.email
                                    } else {
                                        "ERROR EMAIL"
                                    },
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.Gray,
                                    fontSize = 15.sp,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }
                            Text(
                                text = "My Achievement",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                color = Color(0xFF3F3F3F),
                                modifier = Modifier.padding(top = 10.dp)
                            )

                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                                    .border(
                                        0.dp,
                                        Color.Gray,
                                        RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                                    )
                                    .background(color = Color(0xFFF2F7FE))
                                    .padding(bottom = 10.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Row(modifier = Modifier.padding(3.dp)) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text =
                                            if (user.coins.toInt() == 0) {
                                                "0"
                                            } else {
                                                user.coins.toString()
                                            },
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 40.sp,
                                            color = Color(0xFFFAB005),
                                            textAlign = TextAlign.Center
                                        )
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.coin_logo),
                                                contentDescription = "coin_logo",
                                                modifier = Modifier
                                                    .size(20.dp)
                                            )
                                            Spacer(modifier = Modifier.width(2.dp))
                                            Text(
                                                text = "Coins",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 18.sp,
                                                color = Color(0xFF3F3F3F),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Column(
                                        modifier = Modifier.padding(top = 10.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Divider(
                                            modifier = Modifier
                                                .height(60.dp)
                                                .width(1.dp),
                                            color = Color.Gray
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(15.dp))
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Text(
                                            text = missions.size.toString(),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 40.sp,
                                            color = Color.Green
                                        )
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.coin_logo),
                                                contentDescription = "coin_logo",
                                                modifier = Modifier
                                                    .size(20.dp)
                                            )
                                            Spacer(modifier = Modifier.width(2.dp))
                                            Text(
                                                text = "Missions",
                                                fontWeight = FontWeight.SemiBold,
                                                fontSize = 18.sp,
                                                color = Color(0xFF3F3F3F),
                                            )
                                        }
                                    }
                                }
                            }
                            Text(
                                text = "My badges",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 15.sp,
                                color = Color(0xFF3F3F3F),
                                modifier = Modifier.padding(top = 10.dp)
                            )
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                                    .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                                    .border(
                                        0.dp,
                                        Color.Gray,
                                        RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                                    )
                                    .background(color = Color(0xFFF2F7FE)),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                LazyRow(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .padding(bottom = 10.dp)
                                ) {
                                    items(uBadges.size) { item ->
                                        badgess(
                                            picture = uBadges[item].image,

                                            )
                                    }
                                }
                            }

                        }
                    }

                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1.5F)
            ) {
                Text(
                    text = "General", fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xFF3F3F3F),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(start = 20.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .padding(start = 5.dp)
                        .fillMaxHeight(0.22F)
                        .padding(end = 20.dp)
                        .padding(top = 5.dp)
                        .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .border(0.dp, Color.Gray, RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .background(color = Color(0xFFF2F7FE))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 20.dp)
                            .padding(start = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bronze_medal),
                            contentDescription = "badge",
                            modifier = Modifier

                                .size(40.dp),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 76.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Profile Settings", fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = Color(0xFF3F3F3F)
                        )
                        Text(
                            text = "Update and modify your profile",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            color = Color.Gray,
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .padding(start = 5.dp)
                        .fillMaxHeight(0.28F)
                        .padding(end = 20.dp)
                        .padding(top = 5.dp)
                        .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .border(0.dp, Color.Gray, RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .background(color = Color(0xFFF2F7FE))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 20.dp)
                            .padding(start = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bronze_medal),
                            contentDescription = "badge",
                            modifier = Modifier

                                .size(40.dp),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 120.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Language", fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = Color(0xFF3F3F3F)
                        )
                        Text(
                            text = "Choose your language", fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            color = Color.Gray,
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .fillMaxHeight(0.38F)
                        .padding(start = 5.dp)
                        .padding(end = 20.dp)
                        .padding(top = 5.dp)
                        .clip(RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .border(0.dp, Color.Gray, RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp))
                        .background(color = Color(0xFFF2F7FE))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 20.dp)
                            .padding(start = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bronze_medal),
                            contentDescription = "badge",
                            modifier = Modifier

                                .size(40.dp),
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 120.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Logout", fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp,
                            color = Color(0xFF3F3F3F)
                        )
                        Text(
                            text = "Log out of the account", fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            color = Color.Gray,
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = "Arrow Icon",
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }


            }
        }


        Footer(navController = navController, "Profile")

    }


}

@Composable
fun General(texta: String, textb: String, picture: String) {
    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(0.3F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = "badge",
                modifier = Modifier
                    .weight(6f)
                    .padding(bottom = 3.dp)
                    .size(30.dp),
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(0.3F),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$texta", fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color(0xFF3F3F3F)
            )
            Text(
                text = "$textb", fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.Gray,
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(0.3F),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Rounded.KeyboardArrowRight,
                contentDescription = "Arrow Icon",
                tint = Color.Gray,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun badgess(picture: String) {
    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)
    Image(
        painter = painterResource(
            id = context.resources.getIdentifier(
                picture,
                "drawable",
                context.packageName
            )
        ),
        contentDescription = "badge",
        modifier = Modifier
            .padding(bottom = 3.dp)
            .padding(end = 10.dp)
            .size(60.dp),
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Profile_preview() {
    val navController = rememberNavController()
    Profile(navController = navController, userViewModel = UserVM(), missionViewModel = MissionVM(), badgeViewModel = BadgeVM())
//    val navController = rememberNavController()
//
}
