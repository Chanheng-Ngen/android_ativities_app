package com.example.relatiive_layout.api.service

import com.example.relatiive_layout.api.model.Profile
import retrofit2.http.GET

interface ApiService {
    @GET(value = "profile.json")
    suspend fun getProfile(): Profile
}