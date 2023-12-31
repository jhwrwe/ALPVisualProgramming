package com.example.alpvisualprogramming.model

import java.time.LocalDate
import java.time.LocalTime

data class Work_list(
    var list_id: Int = 0,
    var work_title: String = "",
    var date: LocalDate? = null,
    var time: LocalTime? = null,
    var urgency_status: Int = 0,
    var progress_status: Boolean = false,
    var description: String = "",
    var location: String = "",
    var image: String = "",
//    var user_id: String = "",
)
