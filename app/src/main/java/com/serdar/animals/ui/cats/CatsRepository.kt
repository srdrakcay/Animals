package com.serdar.animals.ui.cats

import com.serdar.animals.service.ApiService
import javax.inject.Inject

class CatsRepository
    @Inject constructor(private val apiService: ApiService){

        suspend fun getCats()=apiService.getCats()
    }
