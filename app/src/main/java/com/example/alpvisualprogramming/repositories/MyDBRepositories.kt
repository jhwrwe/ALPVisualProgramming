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
//        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
        return result.message
    }
    suspend fun create_badge(badge: Badge):String{
        val result = myDBService.createBadge(badge)
//        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
        return result.message
    }
    suspend fun deleteBadge(badge: Badge):String{
        val result = myDBService.deleteBadge(badge)
//        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
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
    suspend fun getAllBadge(): List<Badge>{
        try {
            val AllBadge = myDBService.getAllBadge().data as? List<Badge>
            val data = mutableListOf<Badge>()
            if(AllBadge != null){
                for (badges in AllBadge){
                    val badgeaa = Badge(
                        badges.image,
                        badges.name,
                        badges.price
                    )
                    data.add(badgeaa)
                }
            }
            return data
        }catch (e: Exception){
            Log.d("Error11", e.message.toString())
            return mutableListOf()
        }
    }

    suspend fun getAllUserBadge(): List<Badge>{
        try {
            val AllBadge = myDBService.getAllBadgeUserHas().data as? List<Badge>
            val data = mutableListOf<Badge>()
            if(AllBadge != null){
                for (badges in AllBadge){
                    val badgeaa = Badge(
                        badges.image,
                        badges.name,
                        badges.price
                    )
                    data.add(badgeaa)
                }
            }
            return data
        }catch (e: Exception){
            Log.d("Error11", e.message.toString())
            return mutableListOf()
        }
    }

    //mission
    suspend fun createMission(mission: Mission):String{
        val result = myDBService.createMission(mission)
//        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
        return result.message
    }
    suspend fun getAllMission(): List<Mission>{
        try {
            val AllMission = myDBService.getAllMission().data as? List<Mission>
            val data = mutableListOf<Mission>()
            if(AllMission != null){
                for (Mission in AllMission){
                    val mission = Mission(
                        Mission.title,
                        Mission.description,
                        Mission.quantity,
                        Mission.coins,
                        Mission.urgency_status,
                        Mission.user_id,
                    )
                    data.add(mission)
                }
            }
            return data
        }catch (e: Exception){
            Log.d("Error11", e.message.toString())
            return mutableListOf()
        }
    }
    suspend fun claimMissionCoin(id:Int):String{
        val result = myDBService.claimMissionCoin(id)
        return result.message
    }

    suspend fun deleteMission(id:Int):String{
        val result = myDBService.deleteMission(id)
        return result.message
    }

    //user
    suspend fun logout():String{
        val result = myDBService.logout()
        return result.message
    }
    suspend fun register(user: User):String{
        val result = myDBService.register(user)
//        if(result.status.toInt()== HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
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

    suspend fun getTodolistDetail(id: Int): Todolist{
        val todolist = myDBService.getTodolistDetail(id).data as Todolist
        val data = Todolist(
            todolist.title,
            todolist.date,
            todolist.time,
            todolist.urgency_status,
            todolist.description,
            todolist.progress_status,
            todolist.location,
        )
        return data
    }

    suspend fun getLateTodolist(): List<Todolist>{
        try {
            val listTodolists = myDBService.getLateTodolists().data as? List<Todolist>
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

    suspend fun getTodayTodolist(): List<Todolist>{
        try {
            val listTodolists = myDBService.getTodayTodolists().data as? List<Todolist>
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

    suspend fun getTomorrowTodolist(): List<Todolist>{
        try {
            val listTodolists = myDBService.getTomorrowTodolists().data as? List<Todolist>
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

    suspend fun getSomedayTodolist(): List<Todolist>{
        try {
            val listTodolists = myDBService.getSomedayTodolists().data as? List<Todolist>
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

    suspend fun getDoneTodolist(): List<Todolist>{
        try {
            val listTodolists = myDBService.getDoneTodolists().data as? List<Todolist>
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

    suspend fun createTodolist(todolist: Todolist):String{
        val result = myDBService.createTodolist(todolist)
//        if(result.status.toInt()==HttpURLConnection.HTTP_OK){
//            return result.data as String
//        }
        return result.message
    }

    suspend fun deleteTodolist(id:Int):String{
        val result = myDBService.deleteTodolist(id)
        return result.message
    }

    suspend fun todolistDone(id:Int):String{
        val result = myDBService.todolistDone(id)
        return result.message
    }
}