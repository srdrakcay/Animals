package com.serdar.animals.ui.cats

import com.serdar.animals.service.CatsService
import javax.inject.Inject

class CatsRepository
    @Inject constructor(private val catsService: CatsService)
{

        suspend fun getCats()=catsService.getCats()


    }
