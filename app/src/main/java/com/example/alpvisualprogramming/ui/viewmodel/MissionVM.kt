package com.example.alpvisualprogramming.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.repositories.MyDBContainer
import com.example.alpvisualprogramming.repositories.MyDBRepositories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

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


    fun claimMissionCoins(id: Int) :String {
        var message : Any = ""
        viewModelScope.launch {
            val message = MyDBContainer().myDBRepositories.claimMissionCoin(id)
        }
        return message.toString()
    }
}
