package com.serdar.animals.ui.dogs

import com.serdar.animals.service.DogsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class DogsRepository
@Inject constructor(private val dogsService: DogsService){

    suspend fun getDogs()= withContext(Dispatchers.IO){
        dogsService.getDogs()
    }
}
