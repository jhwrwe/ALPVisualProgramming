package com.example.alpvisualprogramming.repositories

import android.util.Log
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.User
import com.example.alpvisualprogramming.services.MyDBService
import com.google.gson.reflect.TypeToken
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
    suspend fun getdatauser(): List<User>{

        try {
            val user = myDBService.getdatauser().data as? List<User>
            val data = mutableListOf<User>()
            if(user != null){
                for (users in user){
                    val userr = User(
                        users.fullname,
                        users.phone_number,
                        users.username,
                        users.coins,
                        users.role_id,
                        users.profile_photo_path,
                        users.password,
                    )
                    data.add(userr)
                }
            }
            return data
        }catch (e: Exception){
            Log.d("Error11", e.message.toString())
            return mutableListOf()
        }
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
    suspend fun user_badge(id:Int):String{
        val result = myDBService.create_Badge_user(id)
        return result.message
    }
    suspend fun coins_minus(id:Int):String{
        val result = myDBService.decreasingcoins(id)
        return result.message
    }
//    suspend fun getAllBadge(): List<Badge>{
//        try {
//            val AllBadge = myDBService.getAllBadge().data as? List<Badge>
//            val data = mutableListOf<Badge>()
//            if(AllBadge != null){
//                for (badges in AllBadge){
//                    val badgeaa = Badge(
//                        badges.id,
//                        badges.image,
//                        badges.name,
//                        badges.price
//                    )
//                    data.add(badgeaa)
//                }
//            }
//            return data
//        }catch (e: Exception){
//            Log.d("Error11", e.message.toString())
//            return mutableListOf()
//        }
//    }
    suspend fun getAllBadge(): List<Badge> {
        try {
            val allBadgeResponse = myDBService.getAllBadge()
            val data = mutableListOf<Badge>()

            if (allBadgeResponse != null) {
                val allBadge = allBadgeResponse.data as? List<Map<String, Any>>

                if (allBadge != null) {
                    for (badgess in allBadge) {
                        val badges = Badge(
                            // missionMap["id"] as Int, // Uncomment if 'id' is present
                            badgess["id"] as Double,
                            badgess["image"] as String,
                            badgess["name"] as String,
                            badgess["price"] as Double,

                            )
                        data.add(badges)
                    }
                }
            }

            return data
        } catch (e: Exception) {
            Log.d("Error11", e.message.toString())
            return emptyList()
        }
    }

//    suspend fun getAllUserBadge(): List<Badge>{
//        try {
//            val AllBadge = myDBService.getAllBadgeUserHas().data as? List<Badge>
//            val data = mutableListOf<Badge>()
//            if(AllBadge != null){
//                for (badges in AllBadge){
//                    val badgeaa = Badge(
//                        badges.id,
//                        badges.image,
//                        badges.name,
//                        badges.price
//                    )
//                    data.add(badgeaa)
//                }
//            }
//            return data
//        }catch (e: Exception){
//            Log.d("Error11", e.message.toString())
//            return mutableListOf()
//        }
//    }
    suspend fun getAllUserBadge(): List<Badge> {
        try {
            val allBadgeUserResponse = myDBService.getAllBadgeUserHas()
            val data = mutableListOf<Badge>()

            if (allBadgeUserResponse != null) {
                val alluserbadge = allBadgeUserResponse.data as? List<Map<String, Any>>

                if (alluserbadge != null) {
                    for (userbadge in alluserbadge) {
                        val userbadges = Badge(
                            // missionMap["id"] as Int, // Uncomment if 'id' is present
                            userbadge["id"] as Double,
                            userbadge["image"] as String,
                            userbadge["name"] as String,
                            userbadge["price"] as Double,

                        )
                        data.add(userbadges)
                    }
                }
            }

            return data
        } catch (e: Exception) {
            Log.d("Error11", e.message.toString())
            return emptyList()
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
    suspend fun getAllMission(): List<Mission> {
        try {
            val allMissionResponse = myDBService.getAllMission()
            val data = mutableListOf<Mission>()

            if (allMissionResponse != null) {
                val allMission = allMissionResponse.data as? List<Map<String, Any>>

                if (allMission != null) {
                    for (missionMap in allMission) {
                        val mission = Mission(
                            // missionMap["id"] as Int, // Uncomment if 'id' is present
                            missionMap["title"] as String,
                            missionMap["description"] as String,
                            missionMap["quantity"] as Double,
                            missionMap["coins"] as Double
                        )
                        data.add(mission)
                    }
                }
            }

            return data
        } catch (e: Exception) {
            Log.d("Error11", e.message.toString())
            return emptyList()
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
                        todolist.id,
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
            todolist.id,
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
                        todolist.id,
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
                        todolist.id,
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
                        todolist.id,
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
                        todolist.id,
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
                        todolist.id,
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