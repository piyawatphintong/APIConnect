package com.example.apiconnect.Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinPriceAPI {
    @GET("simple/price")
    suspend fun getCoinPrice(
        @Query("ids") ids: String,
        @Query("vs_currencies") vsCurrencies: String
    ): Response<Map<String, Map<String, Double>>>
}