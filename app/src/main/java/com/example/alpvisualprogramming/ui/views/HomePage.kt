package com.example.alpvisualprogramming.ui.views

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alpvisualprogramming.R

@Composable
fun MainPageView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier.background(Color(0xFF3960E6)),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = "Application Name",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                ) {
                    Text(
                        text = "Hello,",
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Richie Reuben",
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Priority Matrix",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF3F3F3F),
                modifier = Modifier.padding(vertical = 12.dp)
            )
            // Card dengan tulisan "Schedule" di atas dan "Points" di bawah
            LazyRow(
                content = {
                    item {
                        ColoredCard("Schedule", "Points", Color(0xFF00CD00))
                    }
                    item {
                        ColoredCard("Meetings", "Agenda", Color(0xFF007AFF))
                    }
                    item {
                        ColoredCard("Tasks", "Progress", Color(0xFFDB8901))
                    }
                    item {
                        ColoredCard("Events", "Details", Color(0xFFDF013A))
                    }
                }
            )
            Text(
                text = "Deadline",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF3F3F3F),
                modifier = Modifier.padding(bottom = 12.dp, top = 20.dp)
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_time_96,
                text = "Too Late",
                number = 42
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_deadline_96,
                text = "Today",
                number = 42
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_do_not_disturb_ios_96,
                text = "Tomorrow",
                number = 42
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_question_96,
                text = "Someday",
                number = 42
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_no_data_availible_96,
                text = "No Deadline",
                number = 42
            )
            IconTextNumberCard(
                imageResId = R.drawable.icons8_done_96,
                text = "Done",
                number = 42
            )
        }
    }
}

@Composable
fun ColoredCard(title: String, subtitle: String, color: Color) {
    val gradient = Brush.horizontalGradient(
        colors = listOf(
            color,
            color.copy(alpha = 0.8f),
            color.copy(alpha = 0.5f)
        )
    )

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .padding(end = 8.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawRect(brush = gradient)
                    drawContent()
                },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = subtitle,
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
fun IconTextNumberCard(imageResId: Int, text: String, number: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(bottom = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F8FF)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 4.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Ikon di sebelah kiri
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )

            // Teks di sebelah ikon
            Text(
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF3F3F3F),
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            )

            // Angka di pojok kanan
            Text(
                text = number.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color(0xFF3F3F3F),
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainPagePreview(){
    MainPageView()
}