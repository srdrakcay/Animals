package com.serdar.animals.ui.dogs

import com.serdar.animals.service.ApiService
import javax.inject.Inject


class DogsRepository
@Inject constructor(private val apiService: ApiService){

    suspend fun getDogs()=apiService.getDogs()
}
