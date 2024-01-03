package com.example.alpvisualprogramming.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.Data.DataStoreManager
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.repositories.MyDBContainer
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    fun ButtonLogin (username:String, password:String, context: Context, navController: NavController, dataStore: DataStoreManager){
       viewModelScope.launch {
           val token = MyDBContainer().myDBRepositories.login(username, password)
           if (token.equals("Incorrect Password", true)){
               Toast.makeText(context, token, Toast.LENGTH_LONG).show()
           }else if(token.equals("User not found",true)){
               Toast.makeText(context, token, Toast.LENGTH_LONG).show()
           }else {
               navController.navigate(ListScreen.ListApp.name){
                   popUpTo(ListScreen.Login.name){inclusive=true}
               }
               dataStore.saveToken(token)

               dataStore.getToken.collect { token ->
                   if (token != null){
                       MyDBContainer.ACCESS_TOKEN=token
                   }
               }
           }
       }
    }

    fun ButtonRegister(username:String, fullname:String , phone_number:String,email:String, profile_photo_path:String, password: String, context: Context, navController: NavController){
        viewModelScope.launch {
            val CreateUsernotpermanent = User(fullname, phone_number, username, 0, 2, email, profile_photo_path, password)
            val finnish = MyDBContainer().myDBRepositories.register(CreateUsernotpermanent)
            if (finnish.equals("Success",true)){
                navController.navigate(ListScreen.Login.name){
                    popUpTo(ListScreen.Register.name)
                }
            }
        }
    }
}