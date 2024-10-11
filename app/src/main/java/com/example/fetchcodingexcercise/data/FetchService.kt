package com.example.fetchcodingexcercise.data

import com.example.fetchcodingexcercise.ui.theme.FetchItem
import retrofit2.http.GET

interface FetchService {
    @GET("hiring.json")
    suspend fun getHiring(): List<FetchItem>
}