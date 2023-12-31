package com.example.alpvisualprogramming.globalvariable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GlobalVariable() {
    companion object {

        var _usera = MutableStateFlow(User())
        val usera: StateFlow<User> = _usera.asStateFlow()

        val _missions = MutableStateFlow<List<Mission>>(emptyList())
        val missions: StateFlow<List<Mission>> = _missions.asStateFlow()

        val _badges = MutableStateFlow<List<Badge>>(emptyList())
        val badges: StateFlow<List<Badge>> = _badges.asStateFlow()

        val _uBadges = MutableStateFlow<List<Badge>>(emptyList())
        val uBadges: StateFlow<List<Badge>> = _uBadges.asStateFlow()

        val _todolists = MutableStateFlow<List<Todolist>>(emptyList())
        val todolists: StateFlow<List<Todolist>> = _todolists.asStateFlow()

        var urgency: Int = 0;

        val _todolistDetail = MutableStateFlow(Todolist())
        val todolistDetail: StateFlow<Todolist> = _todolistDetail.asStateFlow()

        private val _navigateToNextScreen = MutableStateFlow(false)
        val navigateToNextScreen: StateFlow<Boolean> = _navigateToNextScreen

        var deadlineTitle = ""

        fun triggerNavigation() {
            _navigateToNextScreen.value = true
        }

        fun resetNavigation() {
            _navigateToNextScreen.value = false
        }
        
        var UpdateID = 0;
    }
}