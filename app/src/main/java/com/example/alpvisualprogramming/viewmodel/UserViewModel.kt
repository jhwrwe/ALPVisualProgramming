package com.example.alpvisualprogramming.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.Data.DataStoreManager
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
               navController.navigate(ListScreen.ListMovie.name){
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
}