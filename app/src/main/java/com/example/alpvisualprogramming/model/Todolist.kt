package com.example.alpvisualprogramming.model

import java.sql.Date
import java.sql.Time
import java.time.LocalDate
import java.time.LocalTime

class Todolist (
        var id: Int,
        var title: String = "",
        var date: Date,
        var time: Time,
        var urgency_status: Int = 0,
        var description: String = "",
        var progress_status: Boolean = false,
        var location: String = "",
//    var user_id: String = "",
)