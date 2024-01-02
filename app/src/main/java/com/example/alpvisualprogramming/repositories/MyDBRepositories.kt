package com.example.alpvisualprogramming.repositories

import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
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
}