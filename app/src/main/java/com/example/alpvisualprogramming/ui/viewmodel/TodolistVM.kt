package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.alpvisualprogramming.model.Todolist
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

class TodolistVM : ViewModel() {

    private val _todolists = MutableStateFlow<List<Todolist>>(emptyList())
    val todolists: StateFlow<List<Todolist>> = _todolists.asStateFlow()

    fun getTodolistByUrgency(id: Int, navController: NavController): List<Todolist> {
        var todolistList: List<Todolist> = emptyList()
        viewModelScope.launch{
            todolistList = MyDBContainer().myDBRepositories.getTodolistByUrgency(id) ?: emptyList()
            _todolists.value = todolistList
            navController.navigate(NavGraph.ToDoListRoute)
        }
        return todolistList
    }

    fun ButtonSubmitTodolist(title:String, date:java.sql.Date, time:Time, urgency_status:Int, description:String ,location: String, context: Context, navController: NavController){
        viewModelScope.launch {
            // bisa apa ngaa jika waktu create id null?
            val CreateTodolistnotpermanent = Todolist(null, title, date, time, urgency_status, description, false, location)
            val finnish = MyDBContainer().myDBRepositories.createTodolist(CreateTodolistnotpermanent)
            if (finnish.equals("Success",true)){
//                navController.navigate(NavGraph.LoginPageRoute)
            }
        }
    }

    fun deleteTodolist(id: Int){
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.deleteTodolist(id)
        }
    }
}