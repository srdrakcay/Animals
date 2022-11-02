package com.serdar.animals.ui.dogs

import com.serdar.animals.service.ApiService
import javax.inject.Inject


class DogsRepository
@Inject constructor(private val apiService: ApiService){

    suspend fun getDogs()=apiService.getDogs("London","920becaf84c8771c64330727a5372d45")
}
