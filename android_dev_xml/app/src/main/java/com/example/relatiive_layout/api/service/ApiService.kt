package com.example.relatiive_layout.api.service

import com.example.relatiive_layout.api.model.Profile
import retrofit2.http.GET

interface ApiService {
    @GET(value = "products")
    suspend fun getProfile(): List<Profile>;
}