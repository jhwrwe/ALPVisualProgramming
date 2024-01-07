package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.Data.DataStoreManager
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import kotlinx.coroutines.launch


class UserVM : ViewModel() {

    fun ButtonLogin(
        username: String,
        password: String,
        context: Context,
        navController: NavController,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            val token = MyDBContainer().myDBRepositories.login(username, password)
            if (token.equals("Incorrect Password", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else if (token.equals("User not found", true)) {
                Toast.makeText(context, token, Toast.LENGTH_LONG).show()
            } else {
                dataStore.saveToken(token)
//                getUser()
                navController.navigate(NavGraph.HomePageRoute)
                dataStore.getToken.collect { token ->
                    if (token != null) {
                        MyDBContainer.ACCESS_TOKEN = token
                    }
                }

            }
        }
    }

    fun ButtonRegister(
        username: String,
        fullname: String,
        phone_number: String,
        email: String,
        profile_photo_path: String,
        password: String,
        context: Context,
        navController: NavController
    ) {
        viewModelScope.launch {
            val CreateUsernotpermanent =
                User(fullname, phone_number, username, 0, 2, email, profile_photo_path, password)
            val finnish = MyDBContainer().myDBRepositories.register(CreateUsernotpermanent)
            if (finnish.equals("Success", true)) {
                navController.navigate(NavGraph.LoginPageRoute)
            }
        }
    }

    fun logout(navController: NavController, dataStore: DataStoreManager) {
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.logout()
            dataStore.saveToken("")
            MyDBContainer.ACCESS_TOKEN = ""
            navController.navigate(NavGraph.LoginPageRoute)
        }
    }

    fun getUser(): User {
        var usera: List<User> = emptyList()
        viewModelScope.launch {
            usera = MyDBContainer().myDBRepositories.getdatauser() as List<User>
            if (usera.isNotEmpty()) {
                GlobalVariable._usera.value = usera[0]
                Log.d("_USERA.VALUE", GlobalVariable._usera.value.toString())
            }
        }
        if (usera.isNotEmpty()) {
            return usera[0]
        } else {
            return User()
        }
    }
}