package com.example.alpvisualprogramming.services

import com.example.alpvisualprogramming.model.APIResponse
import com.example.alpvisualprogramming.model.Mission
import com.example.alpvisualprogramming.model.Todolist
import com.example.alpvisualprogramming.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MyDBService{
    @POST("login")
    suspend fun login(@Body user: User): APIResponse

    @DELETE("logout")
    suspend fun  logout():APIResponse
    @POST("create_user")
    suspend fun register(@Body user: User):APIResponse

    //todolist
    @GET("todolist/{urgency}")
    suspend fun getTodolistByUrgency(@Path("urgency") urgency_status: Int): APIResponse

    @GET("todolistDetail/{id}")
    suspend fun getTodolistDetail(@Path("id") id: Int): APIResponse

    @GET("lateTodolists")
    suspend fun getLateTodolists(): APIResponse

    @GET("todayTodolists")
    suspend fun getTodayTodolists(): APIResponse

    @GET("tomorrowTodolist")
    suspend fun getTomorrowTodolists(): APIResponse

    @GET("somedayTodolist")
    suspend fun getSomedayTodolists(): APIResponse

    @GET("doneTodolist")
    suspend fun getDoneTodolists(): APIResponse

    @PATCH("todolist/{id}")
    suspend fun updateTodolist(@Path("id") id: Int, @Body todolist: Todolist): APIResponse

    @DELETE("todolist/{id}")
    suspend fun deleteTodolist(@Path("id") id: Int):APIResponse

    @PATCH("todolistDone/{id}")
    suspend fun todolistDone(@Path("id") id: Int): APIResponse

    //mission
    @POST("mission")
    suspend fun createMission(@Body mission: Mission):APIResponse

    @GET("mission")
    suspend fun getAllMission(): APIResponse

    @PATCH("claimMissionCoin/{id}")
    suspend fun claimMissionCoin(@Path("id") id: Int): APIResponse

    @DELETE("mission/{id}")
    suspend fun deleteMission(@Path("id") id: Int):APIResponse


}