package com.serdar.animals.ui.dogs

import com.serdar.animals.service.DogsService
import javax.inject.Inject


class DogsRepository
@Inject constructor(private val dogsService: DogsService){

    suspend fun getDogs()=dogsService.getDogs()
}
