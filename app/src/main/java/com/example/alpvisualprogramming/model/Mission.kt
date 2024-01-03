package com.example.alpvisualprogramming.model

data class Mission(
    var id : Int = 0,
    var title: String = "",
    var description: String = "",
    var quantity: Int = 0,
    var coins: Int = 0,
    var urgency_status: Int = 0,
    var user_id : Int = 0,
)
