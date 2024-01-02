package com.example.alpvisualprogramming.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.alpvisualprogramming.model.APIResponse
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.services.MyDBServiceImplementation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class MissionVM() : ViewModel() {

    private val _missions = MutableStateFlow<List<Mission>>(emptyList())
    val missions: StateFlow<List<Mission>> = _missions.asStateFlow()

    val retrofit = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val myDBService = MyDBServiceImplementation(retrofit)
    fun fetchMissions() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response: APIResponse = myDBService.getAllMission()

                if (response.status.toInt() == 200) {
                    val missionsList: List<Mission>? = response.data as? List<Mission>
                    if (missionsList != null) {
                        _missions.value = missionsList
                    } else {
                        // Handle null response body
                    }
                } else {
                    // Handle unsuccessful response
                }
            } catch (e: Exception) {
                // Handle network or other errors
            }
        }
    }
}
