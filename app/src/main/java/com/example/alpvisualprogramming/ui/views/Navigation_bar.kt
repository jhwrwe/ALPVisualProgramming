package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Footer() {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
            .shadow(8.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .shadow(8.dp)
                .background(Color(0xFFF3F8FF)),
        ) {
            Spacer(modifier = Modifier.padding(6.dp))
            BottomFooter(
                title = "To Do",
                picture = "to_do",
                Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp),
                Color.Black
            )
            Spacer(modifier = Modifier.padding(6.dp))
            BottomFooter(
                title = "Journal",
                picture = "journal",
                Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp),
                Color.LightGray
            )
            Spacer(modifier = Modifier.padding(6.dp))
            BottomFooter(
                title = "Mission",
                picture = "mission",
                Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp),
                Color.LightGray
            )
            Spacer(modifier = Modifier.padding(6.dp))
            BottomFooter(
                title = "Profile",
                picture = "profile",
                Modifier
                    .weight(1f)
                    .padding(top = 12.dp, bottom = 12.dp),
                Color.LightGray
            )
            Spacer(modifier = Modifier.padding(6.dp))
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
