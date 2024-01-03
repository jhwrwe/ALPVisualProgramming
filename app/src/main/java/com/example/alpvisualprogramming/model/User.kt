package com.example.alpvisualprogramming.model

data class User(
    var fullname: String = "",
    var phone_number: String = "",
    var username: String = "",
    var coins: Int = 0,
    var role_id: Int = 2,
    var email: String = "",
    var profile_photo_path: String = "",
    var password: String = "",
)
