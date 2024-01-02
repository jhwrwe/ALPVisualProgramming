package com.example.alpvisualprogramming.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.ui.viewmodel.MissionVM
import com.example.alpvisualprogramming.ui.views.Input_to_do
import com.example.alpvisualprogramming.ui.views.JournalPageView
import com.example.alpvisualprogramming.ui.views.LogInPageView
import com.example.alpvisualprogramming.ui.views.MainPageView
import com.example.alpvisualprogramming.ui.views.MissionView
import com.example.alpvisualprogramming.ui.views.Profile
import com.example.alpvisualprogramming.ui.views.SignInPageView
import com.example.alpvisualprogramming.ui.views.SignUpPageView
import com.example.alpvisualprogramming.ui.views.TodoListView

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
}

@Composable
fun ApplicationNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavGraph.MissionPageRoute
    ) {
        composable(NavGraph.LoginPageRoute) {
            LogInPageView(navController)
        }
        composable(NavGraph.HomePageRoute) {
            MainPageView(navController)
        }
        composable(NavGraph.InputToDoRoute) {
            Input_to_do(navController)
        }
        composable(NavGraph.JournalPageRoute) {
            JournalPageView(navController)
        }
        composable(NavGraph.MissionPageRoute) {
            MissionView(MissionVM(), navController)
        }
        composable(NavGraph.ProfileRoute) {
            Profile(navController)
        }
        composable(NavGraph.SignInPageRoute) {
            SignInPageView(navController)
        }
        composable(NavGraph.SignUpPage) {
            SignUpPageView(navController)
        }
        composable(NavGraph.ToDoListRoute) {
            TodoListView(navController)
        }
    }
}
