package com.example.alpvisualprogramming.ui.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
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
fun InputToDo(
    navController: NavController,
    todolistViewModel: TodolistVM
) {
    var expanded by remember { mutableStateOf(false) }
    var list = listOf("Do First", "Schedule", "Delegate", "Eliminate")
    var selectedItem by remember { mutableStateOf("") }
    var textfiledsize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }
    var title by rememberSaveable { mutableStateOf("") }
    var dates by rememberSaveable { mutableStateOf("") }
    var time by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }
    var timesicon by remember { mutableStateOf(false) }
    var spaceicon by remember { mutableStateOf(false) }
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
            selection = CalendarSelection.Date { date ->
                Log.d("selectedDate", "$date")
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                dates = formatter.format(date)
            }
        )
        val clockstate = rememberSheetState()
        ClockDialog(state = clockstate, selection = ClockSelection.HoursMinutes { hours, minutes ->
            Log.d("selectedDate", "$hours:$minutes")
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
            customTextFielda(
                value = title,
                onValueChanged = { title = it },
                text = "Add Task Title",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Column() {
                Text(
                    text = "Category",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 10.dp)
                )
//            CustomTextField(
//                value = category,
//                onValueChanged = { category = it },
//                text = "Do first",
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
//                OutlinedTextField(
//                    value = selectedItem,
//                    onValueChange = { selectedItem = it },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .onGloballyPositioned { coordinates ->
//                            textfiledsize = coordinates.size.toSize()
//                        },
//                    label = { Text(text = "Selected Item") },
//                    trailingIcon = {
//                        Icon(icon, "", Modifier.clickable { expanded = !expanded })
//                    }
//                )
                IconButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .onGloballyPositioned { coordinates ->
                            textfiledsize = coordinates.size.toSize()
                        },
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(text = selectedItem, textAlign = TextAlign.Left)
                        Icon(
                            imageVector = icon,
                            contentDescription = "dropdown",
                            Modifier.align(Alignment.CenterEnd)
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current) { textfiledsize.width.toDp() })
                    ) {
                        list.forEach { label ->
                            DropdownMenuItem(text = { Text(text = label) }, onClick = {
                                selectedItem = label
                                expanded = false
                            }, Modifier.background(Color.White))

                        }
                    }
                }

            }
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
                    OutlinedIconButton(
                        onClick = {
                            spaceicon = !spaceicon
                            calenderstate.show()
                        }, modifier = Modifier.fillMaxWidth()
                    ) {
                        if (!spaceicon) {
                            Icon(
                                imageVector = Icons.Outlined.DateRange,
                                contentDescription = "Date Picker Icon"
                            )
                        }
                        Text(text = dates)
                    }

//                    DatePicker(
//                        date = dates,
//                        onDateSelected = { selectedDate -> dates = selectedDate },
//                        modifier = Modifier.fillMaxWidth()
//                    )
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
                    OutlinedIconButton(onClick = {
                        timesicon = !timesicon
                        clockstate.show()
                    }, modifier = Modifier.fillMaxWidth()) {
                        if (!timesicon) {
                            Icon(
                                imageVector = Icons.Outlined.Schedule,
                                contentDescription = "Date Picker Icon"
                            )
                        }
                        Text(text = time)
                    }
//                    TimePicker(
//                        time = time,
//                        onTimeSelected = { selectedTime -> time = selectedTime },
//                        modifier = Modifier.fillMaxWidth()
//                    )
                }
            }
            Text(
                text = "Location",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            customTextFielda(
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
            customTextFielda(
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
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(Color(0xFF3960E5)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Invite people + ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    }
                }
                Column(Modifier.weight(0.95F)) {

                }
            }
            Button(
                onClick = {
                    todolistViewModel.ButtonSubmitTodolist(
                        title,
                        dates,
                        time,
                        selectedItem,
                        description,
                        location,
                        navController
                    )
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


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateToDo(navController: NavController,
              todolistViewModel: TodolistVM) {
    var expanded by remember{ mutableStateOf(false) }
    var list = listOf("Do First", "Schedule", "Delegate", "Eliminate")
    var selectedItem by remember { mutableStateOf("") }
    var textfiledsize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    val todolistsDetail by GlobalVariable.todolistDetail.collectAsState()

    var id by rememberSaveable { mutableStateOf(0) }
    var title by rememberSaveable { mutableStateOf("") }
    var dates by rememberSaveable { mutableStateOf("") }
    var time by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }
    var timesicon by remember{ mutableStateOf(false) }
    var spaceicon by remember{ mutableStateOf(false) }
    id = todolistsDetail?.id!!.toInt()
    title = todolistsDetail?.title.toString()
    dates = todolistsDetail?.date.toString()
    time = todolistsDetail?.time.toString()
    location = todolistsDetail?.location.toString()
    description = todolistsDetail?.description.toString()
    selectedItem = todolistsDetail?.urgency_status.toString()

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
            customTextFielda(
                value = title,
                onValueChanged = { title = it },
                text = "Add Task Title",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Column (){
                Text(
                    text = "Category",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 10.dp)
                )
//            CustomTextField(
//                value = category,
//                onValueChanged = { category = it },
//                text = "Do first",
//                keyboardOptions = KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                modifier = Modifier.fillMaxWidth()
//            )
                IconButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
                        .onGloballyPositioned { coordinates ->
                            textfiledsize = coordinates.size.toSize()
                        },
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(text = selectedItem, textAlign = TextAlign.Left)
                        Icon(
                            imageVector = icon,
                            contentDescription = "dropdown",
                            Modifier.align(Alignment.CenterEnd)
                        )
                    }
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .width(with(LocalDensity.current) { textfiledsize.width.toDp() })
                    ) {
                        list.forEach { label ->
                            DropdownMenuItem(text = { Text(text = label) }, onClick = {
                                selectedItem = label
                                expanded = false
                            }, Modifier.background(Color.White))

                        }
                    }
                }
            }
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
                    OutlinedIconButton(
                        onClick = {
                            spaceicon = !spaceicon
                            calenderstate.show()
                        },modifier=Modifier.fillMaxWidth()) {
                        if(!spaceicon){
                            Icon(imageVector = Icons.Outlined.DateRange, contentDescription = "Date Picker Icon")
                        }
                        Text(text = dates)
                    }

//                    DatePicker(
//                        date = dates,
//                        onDateSelected = { selectedDate -> dates = selectedDate },
//                        modifier = Modifier.fillMaxWidth()
//                    )
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
                    OutlinedIconButton(onClick = {
                        timesicon =!timesicon
                        clockstate.show()
                    },modifier=Modifier.fillMaxWidth()) {
                        if(!timesicon){
                            Icon(imageVector = Icons.Outlined.Schedule, contentDescription = "Date Picker Icon")
                        }
                        Text(text = time)
                    }
//                    TimePicker(
//                        time = time,
//                        onTimeSelected = { selectedTime -> time = selectedTime },
//                        modifier = Modifier.fillMaxWidth()
//                    )
                }
            }
            Text(
                text = "Location",
                fontSize = 15.sp,
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 10.dp)
            )
            customTextFielda(
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
            customTextFielda(
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
                    todolistViewModel.updateTodolist(id, title,dates,time,selectedItem,description,location, navController )
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
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun customtextfieldforCategory() {

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Input_to_dopreview() {
    val navController = rememberNavController()
    InputToDo(navController, TodolistVM());
}