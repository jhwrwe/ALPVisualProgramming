package com.example.alpvisualprogramming.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.repositories.MyDBRepositories
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MissionPageVM(private val myDBRepositories: MyDBRepositories) : ViewModel() {

    private val _missions = MutableStateFlow<List<Mission>>(emptyList())
    val missions: StateFlow<List<Mission>> = _missions.asStateFlow()

    suspend fun getAllMissions(): List<Mission>? {
        val missionsList: List<Mission>? = myDBRepositories.getAllMission()
        return missionsList
    }

    suspend fun claimMissionCoins(id: Int) :String {
        val message = myDBRepositories.claimMissionCoin(id)
        return message.toString()
    }

//    val retrofit = Retrofit.Builder()
//        .baseUrl("http://127.0.0.1:8000")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val myDBService = MyDBServiceImplementation(retrofit)
//    fun fetchMissions() {
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response: APIResponse = myDBService.getAllMission()
//
//                if (response.status.toInt() == 200) {
//                    val missionsList: List<Mission>? = response.data as? List<Mission>
//                    if (missionsList != null) {
//                        _missions.value = missionsList
//                    } else {
//                        // Handle null response body
//                    }
//                } else {
//                    // Handle unsuccessful response
//                }
//            } catch (e: Exception) {
//                // Handle network or other errors
//            }
//        }
//    }
}