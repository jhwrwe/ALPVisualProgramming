package com.example.alpvisualprogramming.ui.views

//import androidx.compose.foundation.layout.RowScopeInstance.weight
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.R
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.viewmodel.TodolistVM


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TodoListView(
    navController: NavController,
    todolistViewModel: TodolistVM,
) {

    val todolists by GlobalVariable.todolists.collectAsState()

//        Log.d("TodolistView", todolists.get(0).toString())

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .background(Color(0xFF3960E6))
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .clickable {
                        navController.navigate(NavGraph.HomePageRoute)
                    }
            )
            Spacer(modifier = Modifier.width(115.dp))
            Text(
                text = "Task To Do",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.frame_5),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Do First",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF3F3F3F),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "8 Task",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color(0xFF8B8E91),
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Text(
            text = "Urgent and important.  Give this task the highest priority.",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color(0xFF3F3F3F),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyColumn(
        ) {
            items(todolists.size) { item ->
                if (todolists[item].progress_status == false) {
                    CardWithCheckbox(
                        id = todolists[item].id,
                        title = todolists[item].title,
                        location = todolists[item].location,
                        date = todolists[item].date,
                        time = todolists[item].time,
                        progress_status = todolists[item].progress_status,
                        navController = navController,
                        VM = todolistViewModel
                    )
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, bottom = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_add_circle_24),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.BottomEnd)
                .padding(4.dp) // Adjust padding as needed
                .clickable {
                    navController.navigate(NavGraph.InputToDoRoute)
                }
        )
    }

}


@Composable
fun CardWithCheckbox(
    title: String,
    location: String,
    date: String,
    time: String,
    id: Int,
    progress_status: Boolean,
    VM: TodolistVM,
    navController: NavController
) {

    Log.d("TODOLIST ID", id.toString())
    var isChecked by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                VM.getTodolistDetail(id, navController)
            },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE4EFFF)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    isChecked = it
                    TodolistVM().ToDoListDone(id)
                    Log.d("CLICKED HERE", "CHECKBOX CLICKED")
                },
                modifier = Modifier
                    .size(24.dp)
//                    .clickable {
//                        TodolistVM().ToDoListDone(id)
//                        Log.d("CLICKED HERE", "CHECKBOX CLICKED")
//                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "$title",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "$location",
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color(0xFF8B8E91)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$date | $time WIB",
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color(0xFF8B8E91)
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.icons8_delete_96),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        VM.deleteTodolist(id, navController)
                    }
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TodoListPreview() {
    val navController = rememberNavController()
    TodoListView(navController, TodolistVM())
}