package com.example.alpvisualprogramming.ui.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.globalvariable.GlobalVariable.Companion._todolistDetail
import com.example.alpvisualprogramming.globalvariable.GlobalVariable.Companion.todolistDetail
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.todolisttempo
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import kotlinx.coroutines.launch

class TodolistVM : ViewModel() {


    fun getTodolistByUrgency(id: Int, navController: NavController): List<Todolist> {
        var todolistList: List<Todolist> = emptyList()
        viewModelScope.launch {
            todolistList = MyDBContainer().myDBRepositories.getTodolistByUrgency(id) ?: emptyList()
            GlobalVariable._todolists.value = todolistList
            Log.d(".value TESTING", GlobalVariable._todolists.value.toString())
            navController.navigate(NavGraph.ToDoListRoute)
            GlobalVariable.urgency = id
        }
        return todolistList
    }

    fun getTodolistDetail(id:Int, navController: NavController){
        viewModelScope.launch {
            val todolistDetail = MyDBContainer().myDBRepositories.getTodolistDetail(id)
            navController.navigate(NavGraph.UpdateTodoListRoute)
            _todolistDetail.value = todolistDetail
        }
    }

    fun updateTodolist(id:Int, title:String, date:String, time:String, urgency_status:String, description:String ,location: String, navController: NavController){
        viewModelScope.launch {
            val US: Int = when(urgency_status) {
                "Do First" -> 1
                "Schedule" -> 2
                "Delegate" -> 3
                "Eliminate" -> 4
                else -> 0
            }

            if (US == 0) {
                navController.navigate(NavGraph.InputToDoRoute)
            }

            val UpdateTodolist = todolisttempo(title, date, time, US, location, description, false)
            val finnish = MyDBContainer().myDBRepositories.updateTodolist(id, UpdateTodolist)
            if (finnish.equals("Success",true)){
                navController.navigate(NavGraph.LoginPageRoute)
            }
        }
    }

    fun ButtonSubmitTodolist( title:String, date:String, time:String, urgency_status:String, description:String ,location: String, navController: NavController){

        viewModelScope.launch {
            val US: Int = when(urgency_status) {
                "Do First" -> 1
                "Schedule" -> 2
                "Delegate" -> 3
                "Event" -> 4
                else -> 0
            }

            if (US == 0) {
                navController.navigate(NavGraph.InputToDoRoute)
            }

            val CreateTodolistnotpermanent = todolisttempo(title, date, time, US, location, description, false)
            val finnish = MyDBContainer().myDBRepositories.createTodolist(CreateTodolistnotpermanent)
            getTodolistByUrgency(GlobalVariable.urgency, navController)
            if (finnish.equals("Success",true)){
                navController.navigate(NavGraph.ToDoListRoute)
            }
        }
    }

    fun deleteTodolist(id: Int, navController: NavController) {
        var todolistList: List<Todolist> = emptyList()
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.deleteTodolist(id)
            todolistList =
                MyDBContainer().myDBRepositories.getTodolistByUrgency(GlobalVariable.urgency)
                    ?: emptyList()
            GlobalVariable._todolists.value = todolistList
        }
    }

    fun ToDoListDone(id: Int) {
        var todolistList: List<Todolist> = emptyList()
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.todolistDone(id)
            Log.d("DONE", "NO ERROR IN todolistDOne(id)s")
            todolistList =
                MyDBContainer().myDBRepositories.getTodolistByUrgency(GlobalVariable.urgency)
                    ?: emptyList()
            Log.d("todolist gottem", "NO ERROR IN todolisList")
            GlobalVariable._todolists.value = todolistList
        }
    }
}