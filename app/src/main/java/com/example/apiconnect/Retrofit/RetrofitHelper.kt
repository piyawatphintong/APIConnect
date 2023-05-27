package com.example.apiconnect.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val baseURL = "https://api.coingecko.com/api/v3/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            // converter factory to convert JSON object to Java object
            .build()
    }
}