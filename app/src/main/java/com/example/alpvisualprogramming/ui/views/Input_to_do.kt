package com.example.alpvisualprogramming.ui.views

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.viewmodel.MissionVM
import com.example.alpvisualprogramming.ui.viewmodel.TodolistVM
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Input_to_do(
    navController: NavController,
    todolistViewModel: TodolistVM,
    ){
    val context = LocalContext.current
//    val urgencyOptions = listOf("Do First", "Schedule", "Delegate", "Eliminate")

    Column( modifier = Modifier.fillMaxSize()){

//        var selectedUrgencyIndex by rememberSaveable { mutableStateOf(0) }
        var title by rememberSaveable { mutableStateOf("") }
        var date by rememberSaveable { mutableStateOf(LocalDate.now()) }
        var time by rememberSaveable { mutableStateOf(LocalTime.now()) }
        val formattedDate by rememberSaveable{ derivedStateOf { DateTimeFormatter.ofPattern("yyyy-MMM-dd").format(date) }}
        val formattedTime by rememberSaveable{ derivedStateOf { DateTimeFormatter.ofPattern("hh:mm").format(time) }}
        var location by rememberSaveable { mutableStateOf("") }
        var urgency by rememberSaveable { mutableStateOf(0) }
        var description by rememberSaveable { mutableStateOf("") }


    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF3960E5))
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Arrow Icon",
            tint = Color.White,
            modifier = Modifier
                .clickable {
                    navController.navigate(NavGraph.ToDoListRoute)
                }
        )
        Text(
            text = "Add new task",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(1F)
        )
    }
        Column ( modifier = Modifier
            .padding(20.dp)
            .padding(top = 20.dp)){
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

            Text(text = "Urgency", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
            customTextFielda(
                value = urgency.toString(), // Konversi Int ke String saat mengatur nilai
                onValueChanged = {
                    try {
                        urgency = it.toInt() // Ubah String ke Int saat menerima nilai
                    } catch (e: NumberFormatException) {
                        // Handle jika input tidak valid
                    }
                },
                text = "Do first",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
//            val datedialogstate = rememberMaterialDialogState()
//            val Timedialogstate = rememberMaterialDialogState()
            Row (Modifier.fillMaxWidth()   , horizontalArrangement = Arrangement.SpaceBetween){
                Column (Modifier.weight(0.95F)) {
                    Text(text = "Date", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
//                    Button(onClick = {
//                        datedialogstate.show()
//                    }) {
//                        Text(text = "Pick date")
//                    }
//                    Text(text = formattedDate)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column (Modifier.weight(0.95F)) {
                    Text(text = "Time", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
//                   Button(onClick = {
//                       Timedialogstate.show()
//                   }) {
//                       Text(text = "Pick Time")
//                  }
//                    Text(text = formattedTime)
                }
            }
//            MaterialDialog(
//                dialogState = datedialogstate,
//                buttons = {
//                    positiveButton(text = "Ok"){
//                        Toast.makeText(context,"clicked ok",Toast.LENGTH_LONG).show()
//                    }
//                    negativeButton(text="cancel")
//                }
//            ) {
//                datepicker(
//                    initialDate = LocalDate.now(),
//                    title ="pick a date",
//                ){
//                    date = it
//                }
//            }
//            MaterialDialog(
//                dialogState = Timedialogstate,
//                buttons = {
//                    positiveButton(text = "Ok"){
//                        Toast.makeText(context,"clicked ok",Toast.LENGTH_LONG).show()
//                    }
//                    negativeButton(text="cancel")
//                }
//            ) {
//                timepicker(
//                    initialTime = LocalTime.now(),
//                    title ="pick a date",
//                ){
//                    time = it
//                }
//            }
            Text(text = "Location", fontSize = 15.sp, color = Color.Gray, fontWeight = FontWeight.SemiBold,modifier = Modifier.padding(top = 10.dp))
            customTextField(
                value = location,
                onValueChanged = { location = it },
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
                value = description,
                onValueChanged = { description = it },
                text = "badadad",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Row (modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
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
            Button(onClick = {
//                todolistViewModel.ButtonSubmitTodolist(
//                    title,
//                    date,
//                    time,
//                    urgency,
//                    description,
//                    location,
//                    context,
//                    navController
//                )
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp),colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customTextFielda(
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

        ),
                trailingIcon ={
                    Icon(
                        imageVector =  Icons.Default.KeyboardArrowDown,
                        contentDescription = "Hide password"
                    )
                }, leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.frame_5),
                contentDescription = "yeah",
                modifier = Modifier
                    .size(20.dp),
            )
        },
    )
    DropdownMenu(expanded = true, onDismissRequest = { /*TODO*/ }) {
        DropdownMenuItem(text = { Text(text = "pil 1") }, onClick = { /*TODO*/ })
        DropdownMenuItem(text = { Text(text = "pil 2") }, onClick = { /*TODO*/ })
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Input_to_dopreview() {
    val navController = rememberNavController()
    Input_to_do(navController, TodolistVM());
}
