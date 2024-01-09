package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.repositories.MyDBContainer
import kotlinx.coroutines.launch

class BadgeVM : ViewModel() {

    init {
        GetAllUserBadge()
        GetAllBadge()
    }

    fun GetAllUserBadge(): List<Badge>? {
        var uBadges: List<Badge> = emptyList()
        viewModelScope.launch {
            uBadges = MyDBContainer().myDBRepositories.getAllUserBadge() ?: emptyList()
            GlobalVariable._uBadges.value = uBadges

        }
        return uBadges
    }

    fun GetAllBadge(): List<Badge>? {
        var badges: List<Badge> = emptyList()
        viewModelScope.launch {
            badges = MyDBContainer().myDBRepositories.getAllBadge() ?: emptyList()
            GlobalVariable._badges.value = badges
        }
        return badges
    }

    fun CreateBadgeUser(badge_id: Int, context: Context, coins: Int, price: Int) {
        viewModelScope.launch {
            val process = MyDBContainer().myDBRepositories.user_badge(badge_id)
            if (coins >= price) {
                Toast.makeText(context, "Successly Bought", Toast.LENGTH_SHORT).show()
                DecreaseCoins(badge_id, context)
            } else {
                Toast.makeText(context, "Not Enough Coins", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun DecreaseCoins(badge_id: Int, context: Context) {
        viewModelScope.launch {
            val finnish = MyDBContainer().myDBRepositories.coins_minus(badge_id)
//            if (finnish.equals("Success",true)){
//            Toast.makeText(context, finnish, Toast.LENGTH_SHORT).show()
//            }
        }
    }

}