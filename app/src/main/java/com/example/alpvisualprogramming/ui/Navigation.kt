package com.example.alpvisualprogramming.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.services.MyDBService
import com.example.alpvisualprogramming.ui.viewmodel.MissionVM
import com.example.alpvisualprogramming.ui.views.Input_to_do
import com.example.alpvisualprogramming.ui.views.JournalPageView
import com.example.alpvisualprogramming.ui.views.MainPageView
import com.example.alpvisualprogramming.ui.views.MissionView
import com.example.alpvisualprogramming.ui.views.Profile
import com.example.alpvisualprogramming.ui.views.SignInPageView
import com.example.alpvisualprogramming.ui.views.SignUpPageView
import com.example.alpvisualprogramming.ui.views.TodoListView

object ViewNav {
    const val HomePageRoute = "HomePage"
    const val InputToDoRoute = "InputToDo"
    const val JournalPageRoute = "JournalPage"
    const val LoginPageRoute = "LoginPage"
    const val MissionPageRoute = "MissionPage"
    const val ProfileRoute = "Profile"
    const val SignInPageRoute = "SignIn"
    const val SignUpPage = "SignUp"
    const val ToDoListRoute = "ToDoList"
}

@Composable
fun ApplicationNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ViewNav.LoginPageRoute
    ) {
        composable(ViewNav.LoginPageRoute) {
            Input_to_do(navController)
        }
        composable(ViewNav.HomePageRoute) {
            MainPageView(navController)
        }
        composable(ViewNav.InputToDoRoute) {
            Input_to_do(navController)
        }
        composable(ViewNav.JournalPageRoute) {
            JournalPageView(navController)
        }
        composable(ViewNav.MissionPageRoute) {
            MissionView(MissionVM(), navController)
        }
        composable(ViewNav.ProfileRoute) {
            Profile(navController)
        }
        composable(ViewNav.SignInPageRoute) {
            SignInPageView(navController)
        }
        composable(ViewNav.SignUpPage) {
            SignUpPageView(navController)
        }
        composable(ViewNav.ToDoListRoute) {
            TodoListView(navController)
        }

    }
}