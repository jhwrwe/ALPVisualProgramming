package com.example.alpvisualprogramming.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.Data.DataStoreManager
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.viewmodel.BadgeVM
import com.example.alpvisualprogramming.ui.viewmodel.MissionVM
import com.example.alpvisualprogramming.ui.viewmodel.TodolistVM
import com.example.alpvisualprogramming.ui.viewmodel.UserVM
import com.example.alpvisualprogramming.ui.views.InputToDo
import com.example.alpvisualprogramming.ui.views.JournalPageView
import com.example.alpvisualprogramming.ui.views.LogInPageView
import com.example.alpvisualprogramming.ui.views.MainPageView
import com.example.alpvisualprogramming.ui.views.MissionView
import com.example.alpvisualprogramming.ui.views.Profile
import com.example.alpvisualprogramming.ui.views.SignInPageView
import com.example.alpvisualprogramming.ui.views.SignUpPageView
import com.example.alpvisualprogramming.ui.views.TodoListView
import com.example.alpvisualprogramming.ui.views.UpdateToDo

object NavGraph {
    const val HomePageRoute = "HomePage"
    const val InputToDoRoute = "InputToDo"
    const val JournalPageRoute = "JournalPage"
    const val LoginPageRoute = "LoginPage"
    const val MissionPageRoute = "MissionPage"
    const val ProfileRoute = "Profile"
    const val SignInPageRoute = "SignIn"
    const val SignUpPage = "SignUp"
    const val ToDoListRoute = "ToDoList"
    const val UpdateTodoListRoute = "UpdateTodoList"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ApplicationNavigation() {
    val navController = rememberNavController()
    val dataStore = DataStoreManager(LocalContext.current)

    NavHost(
        navController = navController,
        startDestination = NavGraph.SignInPageRoute,
    ) {
        composable(NavGraph.LoginPageRoute) {
            if (MyDBContainer.ACCESS_TOKEN.isEmpty()) {
                LogInPageView(UserVM(), navController, dataStore)
            } else {
                navController.navigate(NavGraph.HomePageRoute)
            }
        }
        composable(NavGraph.HomePageRoute) {
            MainPageView(navController, TodolistVM(), UserVM())
        }
        composable(NavGraph.InputToDoRoute) {
            InputToDo(navController,TodolistVM())
        }
        composable(NavGraph.JournalPageRoute) {
            JournalPageView(navController)
        }
        composable(NavGraph.MissionPageRoute) {
            MissionView(MissionVM(), BadgeVM(), UserVM(), navController)
        }
        composable(NavGraph.ProfileRoute) {
            Profile(navController, UserVM(), MissionVM(),BadgeVM())
        }
        composable(NavGraph.SignInPageRoute) {
            SignInPageView(navController)
        }
        composable(NavGraph.SignUpPage) {
            SignUpPageView(UserVM(), navController)
        }
        composable(NavGraph.ToDoListRoute) {
            TodoListView(navController, TodolistVM())
        }
        composable(NavGraph.UpdateTodoListRoute){
            UpdateToDo(navController,TodolistVM(), GlobalVariable.UpdateID)
        }
    }
}
