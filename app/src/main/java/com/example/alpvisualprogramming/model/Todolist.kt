package com.example.alpvisualprogramming.model

import java.sql.Date
import java.sql.Time

class Todolist(
        var id: Int = 0,
        var title: String = "",
        var date: String = "",
        var time: String = "",
        var urgency_status: Int = 0,
        var description: String = "",
        var progress_status: Boolean = false,
        var location: String = "",
//    var user_id: String = "",
)