package com.serdar.animals.di

import com.serdar.animals.service.ApiService
import com.serdar.animals.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrlCats()= Constant.BASE_URL_CATS

    @Provides
    @Singleton
    fun retrofitInstanceCats(BASE_URL_CATS:String):ApiService =
        Retrofit.Builder().baseUrl(BASE_URL_CATS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Provides
    fun baseUrlDogs()= Constant.BASE_URL_DOGS

    @Provides
    @Singleton
    fun retrofitInstanceDogs(BASE_URL_DOGS:String):ApiService =
        Retrofit.Builder().baseUrl(BASE_URL_DOGS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}