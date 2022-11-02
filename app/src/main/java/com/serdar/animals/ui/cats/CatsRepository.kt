package com.serdar.animals.ui.cats

import com.serdar.animals.service.ApiService
import javax.inject.Inject

class CatsRepository
    @Inject constructor(private val apiService: ApiService){

        suspend fun getCats()=apiService.getCats("London","920becaf84c8771c64330727a5372d45")
    }
