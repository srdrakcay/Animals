package com.serdar.animals.service

import com.serdar.animals.data.model.CatResponse
import retrofit2.Response
import retrofit2.http.GET


interface CatsService {
    @GET("v1/images/search")

    suspend fun getCats(
    ): Response<List<CatResponse>>

}