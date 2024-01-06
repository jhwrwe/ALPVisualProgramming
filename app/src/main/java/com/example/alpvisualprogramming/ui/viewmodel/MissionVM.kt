package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.ui.NavGraph
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.example.alpvisualprogramming.ui.viewmodel.UserVM

class MissionVM() : ViewModel() {

    private val _missions = MutableStateFlow<List<Mission>>(emptyList())
    val missions: StateFlow<List<Mission>> = _missions.asStateFlow()

    init {
        getAllMissions()
    }

    fun getAllMissions(): List<Mission> {
        var missionsList: List<Mission> = emptyList()
        viewModelScope.launch {
            missionsList = MyDBContainer().myDBRepositories.getAllMission() ?: emptyList()
            _missions.value = missionsList
        }
        return missionsList
    }


    fun claimMissionCoins(id: Int, remaining: Int, quantity: Int, context: Context, UserVM: UserVM, navController: NavController) {
        var message: String = ""
        viewModelScope.launch {
            if (remaining >= quantity) {
                message = MyDBContainer().myDBRepositories.claimMissionCoin(id)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                UserVM.getUser()
//                navController.navigate(NavGraph.MissionPageRoute)
            } else {
                val remainingQuantity = quantity - remaining
                Toast.makeText(context, "$remainingQuantity Works Remaining", Toast.LENGTH_LONG).show()
            }
        }
    }
}
