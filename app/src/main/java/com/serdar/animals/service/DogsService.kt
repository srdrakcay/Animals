package com.serdar.animals.service

import com.serdar.animals.data.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogsService {

    @GET("v1/images/search")
    suspend fun getDogs(

    ): Response<List<DogResponse>>
}