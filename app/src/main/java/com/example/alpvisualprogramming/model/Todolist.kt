package com.example.alpvisualprogramming.model

import java.time.LocalDate
import java.time.LocalTime

class Todolist (
        var title: String = "",
        var date: LocalDate? = null,
        var time: LocalTime? = null,
        var urgency_status: Int = 0,
        var description: String = "",
        var progress_status: Boolean = false,
        var location: String = "",
//    var user_id: String = "",
)