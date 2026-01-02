package com.example.activityiteapp.api.service

import com.example.activityiteapp.api.model.Activities
import com.example.activityiteapp.api.model.Profile
import retrofit2.http.GET

interface ApiService {
    @GET(value = "profile.json")
    suspend fun getProfile(): Profile;

    @GET(value = "activities.json")
    suspend fun getActivities(): List<Activities>
}