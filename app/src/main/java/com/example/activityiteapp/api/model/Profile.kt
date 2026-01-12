package com.example.activityiteapp.api.model

data class Profile(
    val id : Int,
    val firstName: String,
    val lastName: String,
    val profileImage: String,
    val coverImage: String,
    val major: String,
    val generation: String,
)

