package com.serdar.animals.service

import com.serdar.animals.model.Cats
import com.serdar.animals.model.Dogs
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("v1/images/search")

    suspend fun getCats(
    ): Response<Cats>

    @GET("v1/images/search")
    suspend fun getDogs(

    ): Response<Dogs>
}