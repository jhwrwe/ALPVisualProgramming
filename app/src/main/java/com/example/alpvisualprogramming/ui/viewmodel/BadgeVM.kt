package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.repositories.MyDBContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BadgeVM : ViewModel() {

    private val _badges = MutableStateFlow<List<Badge>>(emptyList())
    val badges: StateFlow<List<Badge>> = _badges.asStateFlow()

    private val _uBadges = MutableStateFlow<List<Badge>>(emptyList())
    val uBadges: StateFlow<List<Badge>> = _uBadges.asStateFlow()

    init {
        GetAllUserBadge()
        GetAllBadge()
    }

    fun GetAllUserBadge(): List<Badge>? {
        var uBadges: List<Badge> = emptyList()
        viewModelScope.launch {
            uBadges = MyDBContainer().myDBRepositories.getAllUserBadge()?: emptyList()
            _uBadges.value = uBadges
        }
        return uBadges
    }

    fun GetAllBadge(): List<Badge>? {
        var badges: List<Badge> = emptyList()
        viewModelScope.launch {
            badges = MyDBContainer().myDBRepositories.getAllBadge()?: emptyList()
            _badges.value = badges
        }
        return badges
    }

    fun CreateBadgeUser(badge_id: Int, context: Context) {
        viewModelScope.launch {
            val finnish = MyDBContainer().myDBRepositories.user_badge(badge_id)
//            if (finnish.equals("Success",true)){
            Toast.makeText(context, finnish, Toast.LENGTH_SHORT).show()
//            }
            DecreaseCoins(badge_id, context)
        }
    }

    fun DecreaseCoins(badge_id: Int, context: Context) {
        viewModelScope.launch {
            val finnish = MyDBContainer().myDBRepositories.coins_minus(badge_id)
//            if (finnish.equals("Success",true)){
            Toast.makeText(context, finnish, Toast.LENGTH_SHORT).show()
//            }
        }
    }

}