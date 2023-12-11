package com.example.alpvisualprogramming.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Input_to_do(){
    Column( modifier = Modifier.fillMaxSize()){
        var title by rememberSaveable { mutableStateOf("") }
        var date by rememberSaveable { mutableStateOf("") }
        var time by rememberSaveable { mutableStateOf("") }
        var Location by rememberSaveable { mutableStateOf("") }
        var Category by rememberSaveable { mutableStateOf("") }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3960E5))
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Arrow Icon",
            tint = Color.White
        )
        Text(
            text = "Add new task",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1F)
        )
    }
        Column ( modifier = Modifier.padding(20.dp)){
            Text(text = "Title", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold)
            customTextField(
                value = title,
                onValueChanged = { title = it },
                text = "Add Task Title",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Text(text = "Category", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
            customTextField(
                value = Category,
                onValueChanged = { Category = it },
                text = "Do first",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row (Modifier.fillMaxWidth()   , horizontalArrangement = Arrangement.SpaceBetween){
                Column (Modifier.weight(0.95F)) {
                    Text(text = "Date", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
                    customTextField(
                        value = date,
                        onValueChanged = { date = it },
                        text = "Des 12, 2023",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column (Modifier.weight(0.95F)) {
                    Text(text = "Time", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
                    customTextField(
                        value = time,
                        onValueChanged = { time = it },
                        text = "12:00",
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }

            }
            Text(text = "Location", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
            customTextField(
                value = Location,
                onValueChanged = { Location = it },
                text = "Juanda airport",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(text = "Description", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
            customTextField(
                value = Location,
                onValueChanged = { Location = it },
                text = "badadad",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row (modifier = Modifier.padding(top = 20.dp). fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
                Column (Modifier.weight(0.95F),){
                    Button(onClick = { /*TODO*/ }, modifier = Modifier
                        .fillMaxWidth(),colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                        shape = RoundedCornerShape(8.dp)) {
                        Text(text = "Invite people + ", fontWeight = FontWeight.Bold,fontSize = 15.sp)
                    }
                }
                Column (Modifier.weight(0.95F)){

                }
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth().padding(top = 50.dp),colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                shape = RoundedCornerShape(8.dp)) {
                Text(text = "Create", fontWeight = FontWeight.Bold,fontSize = 15.sp)
            }

        }
        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    text: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = text) },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        shape = RoundedCornerShape(25),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            textColor = Color.Black
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Input_to_dopreview() {
    Input_to_do();
}
