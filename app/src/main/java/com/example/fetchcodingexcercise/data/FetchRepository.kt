package com.example.fetchcodingexcercise.data

import com.example.fetchcodingexcercise.ui.theme.FetchItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FetchRepository {
    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    suspend fun getHiring(): List<FetchItem> {
        val service = buildRetrofit().create(FetchService::class.java)
        val items = service.getHiring()
        return items.filter { it.name != "" }.sortedWith(compareBy({ it.id }, { it.name }))
    }
}