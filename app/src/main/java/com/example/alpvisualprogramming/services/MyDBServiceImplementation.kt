package com.example.alpvisualprogramming.services

import com.example.alpvisualprogramming.model.APIResponse
import com.example.alpvisualprogramming.model.Badge
import com.example.alpvisualprogramming.model.BadgeUser
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.User
import retrofit2.Retrofit

class MyDBServiceImplementation(private val retrofit: Retrofit) : MyDBService {
    private val myDBService: MyDBService by lazy {
        retrofit.create(MyDBService::class.java)
    }

    override suspend fun login(user: User): APIResponse {
        return myDBService.login(user)
    }

    override suspend fun logout(): APIResponse {
        return myDBService.logout()
    }

    override suspend fun register(user: User): APIResponse {
        return myDBService.register(user)
    }

    override suspend fun getTodolistByUrgency(urgency_status: Int): APIResponse {
        return myDBService.getTodolistByUrgency(urgency_status)
    }

    override suspend fun getTodolistDetail(id: Int): APIResponse {
        return myDBService.getTodolistDetail(id)
    }

    override suspend fun getLateTodolists(): APIResponse {
        return myDBService.getLateTodolists()
    }

    override suspend fun getTodayTodolists(): APIResponse {
        return myDBService.getTodayTodolists()
    }

    override suspend fun getTomorrowTodolists(): APIResponse {
        return myDBService.getTomorrowTodolists()
    }

    override suspend fun getSomedayTodolists(): APIResponse {
        return myDBService.getSomedayTodolists()
    }

    override suspend fun getDoneTodolists(): APIResponse {
        return myDBService.getDoneTodolists()
    }

    override suspend fun updateTodolist(id: Int, todolist: Todolist): APIResponse {
        return myDBService.updateTodolist(id, todolist)
    }

    override suspend fun deleteTodolist(id: Int): APIResponse {
        return myDBService.deleteTodolist(id)
    }

    override suspend fun todolistDone(id: Int): APIResponse {
        return myDBService.todolistDone(id)
    }

    override suspend fun createMission(mission: Mission): APIResponse {
        return myDBService.createMission(mission)
    }

    override suspend fun getAllMission(): APIResponse {
        return myDBService.getAllMission()
    }

    override suspend fun claimMissionCoin(id: Int): APIResponse {
        return myDBService.claimMissionCoin(id)
    }

    override suspend fun deleteMission(id: Int): APIResponse {
        return myDBService.deleteMission(id)
    }

    override suspend fun deleteuser(): APIResponse {
        return myDBService.deleteuser()
    }

    override suspend fun update_bio(user: User): APIResponse {
        return myDBService.update_bio(user)
    }

    override suspend fun createBadge(badge: Badge): APIResponse {
        return myDBService.createBadge(badge)
    }

    override suspend fun deleteBadge(badge: Badge): APIResponse {
        return myDBService.deleteBadge(badge)
    }

    override suspend fun getAllBadge(): APIResponse {
        return myDBService.getAllBadge()
    }

    override suspend fun create_Badge_user(badgeUser: BadgeUser, id: Int): APIResponse {
        return myDBService.create_Badge_user(badgeUser, id)
    }

    override suspend fun deletebadgeuser(): APIResponse {
        return myDBService.deletebadgeuser()
    }

    override suspend fun getAllBadgeUserHas(): APIResponse {
        return myDBService.getAllBadgeUserHas()
    }

    override suspend fun createTodolist(todolist: Todolist): APIResponse {
        TODO("Not yet implemented")
    }

    override suspend fun decreasingcoins(badgeUser: BadgeUser, id: Int): APIResponse {
        return myDBService.decreasingcoins(badgeUser, id)
    }
// Implement the remaining methods...
}
