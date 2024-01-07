package com.example.alpvisualprogramming.ui.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.ui.viewmodel.TodolistVM
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockSelection
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputToDo(navController: NavController,
              todolistViewModel: TodolistVM) {
    var title by rememberSaveable { mutableStateOf("") }
    var dates by rememberSaveable { mutableStateOf("") }
    var time by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        val calenderstate = rememberSheetState()
        CalendarDialog(
            state = calenderstate,
            config = CalendarConfig(
                monthSelection = true,
                yearSelection = true,
                style = CalendarStyle.MONTH,
                disabledDates = listOf(LocalDate.now().plusDays(7))
            ),
            selection = CalendarSelection.Date{date ->
                Log.d("selectedDate","$date")
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                dates = formatter.format(date)
            }
        )
        val clockstate = rememberSheetState()
        ClockDialog(state = clockstate, selection = ClockSelection.HoursMinutes{hours, minutes ->
            Log.d("selectedDate","$hours:$minutes")
            time = "$hours:$minutes"

        })


        Row(
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
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Title",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold
            )
            CustomTextField(
                value = title,
                onValueChanged = { title = it },
                text = "Add Task Title",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = "Category",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomTextField(
                value = category,
                onValueChanged = { category = it },
                text = "Do first",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(Modifier.weight(0.95F)) {
                    Text(
                        text = "Date",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Button(onClick = {
                        calenderstate.show()
                    }) {
                        Text(text = "Date Picker")
                    }
                    DatePicker(
                        date = dates,
                        onDateSelected = { selectedDate -> dates = selectedDate },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column(Modifier.weight(0.95F)) {
                    Text(
                        text = "Time",
                        fontSize = 15.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Button(onClick = {
                        clockstate.show()
                    }) {
                        Text(text = "Time Picker")
                    }
                    TimePicker(
                        time = time,
                        onTimeSelected = { selectedTime -> time = selectedTime },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Text(
                text = "Location",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomTextField(
                value = location,
                onValueChanged = { location = it },
                text = "Juanda airport",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Description",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            CustomTextField(
                value = description,
                onValueChanged = { description = it },
                text = "badadad",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(Modifier.weight(0.95F)) {
                    Button(
                        onClick = {  },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Invite people + ", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                    }
                }
                Column(Modifier.weight(0.95F)) {

                }
            }
            Button(
                onClick = {
                    todolistViewModel.ButtonSubmitTodolist(title,dates,time,0,description,location, navController )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Create", fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }
        }
    }
}
@Composable
fun DatePicker(date: String, onDateSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    OutlinedIconButton(
        onClick = {

            val defaultDate = "Jan 01, 2024"
            onDateSelected(defaultDate)
        },
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Outlined.DateRange, contentDescription = "Date Picker Icon")
        Text(text = date)
    }
}

@Composable
fun TimePicker(time: String, onTimeSelected: (String) -> Unit, modifier: Modifier = Modifier) {
    OutlinedIconButton(
        onClick = {
            val defaultTime = "12:00 PM"
            onTimeSelected(defaultTime)
        },
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Outlined.Schedule, contentDescription = "Time Picker Icon")
        Text(text = time)
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

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Input_to_dopreview() {
    val navController = rememberNavController()
    InputToDo(navController, TodolistVM());
}