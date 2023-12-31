package com.example.alpvisualprogramming.model

import java.time.LocalDate
import java.time.LocalTime

data class Journal(
    var journal_id: Int = 0,
    var title: String = "",
    var descirption: LocalDate? = null,
    var image: LocalTime? = null,
//    var user_id: Int = 0,
)
