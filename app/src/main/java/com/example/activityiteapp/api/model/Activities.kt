package com.example.activityiteapp.api.model
import java.io.Serializable

data class Activities(
    val  id: Int,
    val title: String,
    val date: String,
    val year: Int,
    val imageUrl: String,
    val description: String,
) : Serializable
