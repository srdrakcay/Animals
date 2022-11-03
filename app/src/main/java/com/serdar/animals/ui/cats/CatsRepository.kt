package com.serdar.animals.ui.cats

import com.serdar.animals.service.CatsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatsRepository
    @Inject constructor(private val catsService: CatsService)
{

        suspend fun getCats()= withContext(Dispatchers.IO){
            catsService.getCats()
        }


    }
