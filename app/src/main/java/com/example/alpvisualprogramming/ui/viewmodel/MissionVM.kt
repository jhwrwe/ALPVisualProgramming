package com.example.alpvisualprogramming.ui.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.alpvisualprogramming.globalvariable.GlobalVariable
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.repositories.MyDBContainer
import kotlinx.coroutines.launch

class MissionVM() : ViewModel() {

    init {
        getAllMissions()
    }

    fun getAllMissions(): List<Mission> {
        var missionsList: List<Mission> = emptyList()
        viewModelScope.launch {
            missionsList = MyDBContainer().myDBRepositories.getAllMission() ?: emptyList()
            GlobalVariable._missions.value = missionsList
        }
        return missionsList
    }


    fun claimMissionCoins(
        id: Int,
        remaining: Int,
        quantity: Int,
        context: Context,
        UserVM: UserVM,
        navController: NavController
    ) {
        var message: String = ""
        viewModelScope.launch {
            if (remaining >= quantity) {
                message = MyDBContainer().myDBRepositories.claimMissionCoin(id)
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
                UserVM.getUser()
            } else {
                val remainingQuantity = quantity - remaining
                Toast.makeText(context, "$remainingQuantity Works Remaining", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }
}
