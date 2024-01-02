package com.example.alpvisualprogramming.repositories

import android.util.Log
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.services.MyDBService
import java.net.HttpURLConnection

class MyDBRepositories (private val myDBService: MyDBService){
    suspend fun login(username:String, password:String):String{
        val user = User(username = username, password = password)
        val result = myDBService.login(user)

        if(result.status.toInt()== HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }
    suspend fun deleteuser():String{
        val result = myDBService.deleteuser()
        return result.message
    }

    suspend fun update_bio(user: User):String{
        val result = myDBService.update_bio(user)
        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }
    suspend fun create_badge(badge: Badge):String{
        val result = myDBService.createBadge(badge)
        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }
    suspend fun deleteBadge(badge: Badge):String{
        val result = myDBService.deleteBadge(badge)
        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }
    suspend fun AllBadge(badge:Badge):String{
        val result = myDBService.seeallbadge(badge)
        return result.message
    }
    suspend fun user_badge(badgeUser: BadgeUser, id:Int):String{
        val result = myDBService.create_Badge_user(badgeUser, id)
        return result.message
    }
    suspend fun coins_minus(badgeUser: BadgeUser, id:Int):String{
        val result = myDBService.decreasingcoins(badgeUser, id)
        return result.message
    }
    suspend fun getAllBadge():String{
        val result = myDBService.seeingallthebadge()
        return result.message
    }

    suspend fun create_mission(mission: Mission):String{
        val result = myDBService.createMission(mission)
        return result.message
    }
    suspend fun seeAllMission():Any{
         val result = myDBService.getAllMission()
        return result;
    }
    suspend fun claimMissionCoin(id:Int):String{
        val result = myDBService.claimMissionCoin(id)
        return result.message
    }
    suspend fun deleteMission(id:Int):String{
        val result = myDBService.deleteMission(id)
        return result.message
    }




    suspend fun logout():String{
        val result = myDBService.logout()
        return result.message
    }
    suspend fun register(user: User):String{
        val result = myDBService.register(user)
        if(result.status.toInt()== HttpURLConnection.HTTP_OK){
            return result.data as String
        }
        return result.message
    }


    //todolist
    suspend fun getTodolistByUrgency(urgencyStatus: Int): List<Todolist>{
        try {
            val listTodolists = myDBService.getTodolistByUrgency(urgencyStatus).data as? List<Todolist>
            val data = mutableListOf<Todolist>()
            if(listTodolists != null){
                for (todolist in listTodolists){
                    val todo = Todolist(
                        todolist.title,
                        todolist.date,
                        todolist.time,
                        todolist.urgency_status,
                        todolist.description,
                        todolist.progress_status,
                        todolist.location,
                    )
                    data.add(todo)
                }
            }
            return data
        }catch (e: Exception){
            Log.d("Error11", e.message.toString())
            return mutableListOf()
        }
    }

}