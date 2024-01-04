package com.example.alpvisualprogramming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alpvisualprogramming.ui.ApplicationNavigation
import com.example.alpvisualprogramming.ui.NavGraph
import com.example.alpvisualprogramming.ui.theme.ALPVisualProgrammingTheme

import com.example.alpvisualprogramming.ui.views.Input_to_do
import com.example.alpvisualprogramming.ui.views.JournalPageView
import com.example.alpvisualprogramming.ui.views.LogInPageView
import com.example.alpvisualprogramming.ui.views.MainPageView
import com.example.alpvisualprogramming.ui.views.MissionView
import com.example.alpvisualprogramming.ui.views.Profile
import com.example.alpvisualprogramming.ui.views.SignInPageView
import com.example.alpvisualprogramming.ui.views.SignUpPageView
import com.example.alpvisualprogramming.ui.views.TodoListView

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ALPVisualProgrammingTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//            val navController = rememberNavController()

            ApplicationNavigation()

//            NavHost(
//                navController = navController,
//                startDestination = NavGraph.MissionPageRoute
//            ) {
//                composable(NavGraph.LoginPageRoute) {
//                    LogInPageView(navController)
//                }
//                composable(NavGraph.HomePageRoute) {
//                    MainPageView(navController)
//                }
//                composable(NavGraph.InputToDoRoute) {
//                    Input_to_do(navController)
//                }
//                composable(NavGraph.JournalPageRoute) {
//                    JournalPageView(navController)
//                }
//                composable(NavGraph.MissionPageRoute) {
//                    MissionView(MissionVM(), navController)
//                }
//                composable(NavGraph.ProfileRoute) {
//                    Profile(navController)
//                }
//                composable(NavGraph.SignInPageRoute) {
//                    SignInPageView(navController)
//                }
//                composable(NavGraph.SignUpPage) {
//                    SignUpPageView(navController)
//                }
//                composable(NavGraph.ToDoListRoute) {
//                    TodoListView(navController)
//                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ALPVisualProgrammingTheme {
        Greeting("Android")
    }
}