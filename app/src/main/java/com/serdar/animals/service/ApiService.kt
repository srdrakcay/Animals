package com.serdar.animals.service

import com.serdar.animals.model.Cats
import com.serdar.animals.model.Dogs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("data/2.5/weather")

    suspend fun getCats(
        @Query("q") location: String,
        @Query("appid") key: String ="920becaf84c8771c64330727a5372d45",
    ): Response<Cats>

    suspend fun getDogs(
        @Query("q") location: String,
        @Query("appid") key: String ="920becaf84c8771c64330727a5372d45",
    ): Response<Dogs>
}