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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.alpvisualprogramming.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun Profile() {
    Column ( modifier = Modifier.fillMaxSize()){
        Box(
            modifier = Modifier
                .zIndex(2f)
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3F)
                    .zIndex(1f)
                    .background(color = Color(0xFF3960E5)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(20.dp)
                )
            }
            Column(
                modifier = Modifier
                    .zIndex(2f)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5F)
                    .padding(top = 60.dp)
                    .clip(shape = RoundedCornerShape(0.dp)),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.9F)
                        .fillMaxHeight()
                        .background(Color.White)
                        .padding(20.dp),
                    colors = CardDefaults.cardColors(Color.White),
                ) {
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                   Image(painter = , contentDescription = )
                    }
                    Column(
                        Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Richie Reuben",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF3F3F3F)
                        )
                        Text(
                            text = "richirebuenh@gmail.com",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray,
                            fontSize = 15.sp,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                    Text(
                        text = "My Achievement",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color(0xFF3F3F3F),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .background(color = Color(0xFFF2F7FE))
                            .clip(RoundedCornerShape(30.dp, 30.dp, 30.dp, 30.dp))
                            ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {
                            Column(verticalArrangement = Arrangement.Center) {
                                Text(
                                    text = "1340",
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
                            Spacer(modifier = Modifier.width(30.dp))
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "200",
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
                        fontSize = 18.sp,
                        color = Color(0xFF3F3F3F),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Column(
                        Modifier.fillMaxWidth().background(color = Color(0xFFF2F7FE)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LazyRow(modifier = Modifier.padding(top = 10.dp)) {
                            item {
                                badgess(
                                    picture = "bronze_medal"
                                )
                            }
                            item {
                                badgess(
                                    picture = "silver_medal"
                                )
                            }
                            item {
                                badgess(
                                    picture = "gold_medal"
                                )
                            }
                            item {
                                badgess(
                                    picture = "sandglass"
                                )
                            }
                        }
                    }

                }

            }

        }
            Text(text = "General",fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color(0xFF3F3F3F),
                modifier = Modifier.padding(top = 10.dp).padding(start=40.dp))
            Row (modifier = Modifier
                .fillMaxWidth().padding(5.dp).padding(start=40.dp).padding(end=20.dp).padding(top=20.dp).background(color = Color(0xFFF2F7FE)), horizontalArrangement = Arrangement.SpaceBetween){
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Image(
                        painter = painterResource(id = R.drawable.bronze_medal),
                        contentDescription = "badge",
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                            .size(40.dp),
                    )
                }
                Column (
                    verticalArrangement = Arrangement.Center){
                    Text(text = "Profile Settings", fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = Color(0xFF3F3F3F))
                    Text(text = "Update and modify your profile" ,fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = Color.Gray,
                    )
                }
                Column (modifier=Modifier.padding(top=10.dp),horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    Icon(
                        imageVector = Icons.Rounded.KeyboardArrowRight,
                        contentDescription = "Arrow Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(30.dp)

                    )
                }
            }
        Row (modifier = Modifier
            .fillMaxWidth().padding(5.dp).padding(start=40.dp).padding(end=20.dp).padding(top=20.dp).background(color = Color(0xFFF2F7FE))){
            Column (modifier = Modifier.padding(end=40.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.bronze_medal),
                    contentDescription = "badge",
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .size(40.dp),
                )
            }
            Column (modifier = Modifier.padding(end=90.dp),
                verticalArrangement = Arrangement.Center){
                Text(text = "Language", fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xFF3F3F3F))
                Text(text = "Choose your language" ,fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
            }
            Column (modifier=Modifier.padding(top=10.dp),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "Arrow Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth().padding(5.dp).padding(start=40.dp).padding(end=20.dp).padding(top=20.dp).background(color = Color(0xFFF2F7FE))){
            Column (modifier = Modifier.padding(end=40.dp), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Image(
                    painter = painterResource(id = R.drawable.bronze_medal),
                    contentDescription = "badge",
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .size(40.dp),
                )
            }
            Column (modifier = Modifier.padding(end=90.dp),
                verticalArrangement = Arrangement.Center){
                Text(text = "Logout", fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color(0xFF3F3F3F))
                Text(text = "Log out of the account" ,fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
            }
            Column (modifier=Modifier.padding(top=10.dp),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center){
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowRight,
                    contentDescription = "Arrow Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
            }
        }


        }

        Spacer(modifier = Modifier.height(4.dp))
    }

@Composable
fun General(texta:String, textb:String,picture:String){
    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)
    Row (modifier = Modifier
        .fillMaxWidth().padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween){
        Column (modifier = Modifier.fillMaxHeight(0.3F),horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Image(
            painter = painterResource(id = drawable),
            contentDescription = "badge",
            modifier = Modifier
                .weight(6f)
                .padding(bottom = 3.dp)
                .size(30.dp),
        )
        }
        Column (modifier = Modifier.fillMaxHeight(0.3F),
            verticalArrangement = Arrangement.Center){
            Text(text = "$texta", fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color(0xFF3F3F3F))
            Text(text = "$textb" ,fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.Gray,
                )
        }
        Column (modifier = Modifier.fillMaxHeight(0.3F),horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
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
fun badgess(picture: String){
    val context = LocalContext.current
    val drawable = stringToDrawableId(context, picture)
    Image(
        painter = painterResource(id = drawable),
        contentDescription = "badge",
        modifier = Modifier
            .padding(bottom = 3.dp)
            .padding(end = 10.dp)
            .size(50.dp),
    )
}








@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Profile_preview() {
    Profile();
}
