package com.serdar.animals.ui.cats

import com.serdar.animals.service.CatsService
import com.serdar.animals.service.DogsService
import javax.inject.Inject

class CatsRepository
    @Inject constructor(private val catsService: CatsService)
{

        suspend fun getCats()=catsService.getCats()


    }
