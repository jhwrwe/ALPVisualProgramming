package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import kotlinx.coroutines.launch

class BadgeVM: ViewModel() {

    suspend fun GetAllUserBadge(): List<Badge>? {
        val finnish = MyDBContainer().myDBRepositories.getAllUserBadge()
        return finnish
    }

    suspend fun GetAllBadge(): List<Badge>? {
        val finnish = MyDBContainer().myDBRepositories.getAllBadge()
        return finnish
    }

    fun CreateBadgeUser(user_id:Int, badge_id:Int, context:Context){
        viewModelScope.launch {
            val badgeUser = BadgeUser(badge_id, user_id)
            val finnish = MyDBContainer().myDBRepositories.user_badge(badgeUser, badge_id)
//            if (finnish.equals("Success",true)){
                Toast.makeText(context,finnish,Toast.LENGTH_SHORT).show()
//            }
        }
    }

    fun DecreaseCoins(user_id:Int, badge_id:Int, context:Context){
        viewModelScope.launch {
            val badgeUser = BadgeUser(badge_id, user_id)
            val finnish = MyDBContainer().myDBRepositories.coins_minus(badgeUser, badge_id)
//            if (finnish.equals("Success",true)){
            Toast.makeText(context,finnish,Toast.LENGTH_SHORT).show()
//            }
        }
    }

}