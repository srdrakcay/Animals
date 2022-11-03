package com.serdar.animals.di

import android.content.Context
import com.serdar.animals.data.wrapper.AdsOperator
import com.serdar.animals.service.CatsService
import com.serdar.animals.service.DogsService
import com.serdar.animals.utils.Constant
import com.serdar.animals.utils.Constant.BASE_URL_CATS
import com.serdar.animals.utils.Constant.BASE_URL_DOGS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton
@Qualifier
annotation class CatsRetrofitInstance

@Qualifier
annotation class DogsRetrofitInstance
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrlCats()= Constant.BASE_URL_CATS

    @CatsRetrofitInstance
    @Provides
    @Singleton
    fun retrofitInstanceCats(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL_CATS)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    @Provides
    fun baseUrlDogs()= Constant.BASE_URL_DOGS

    @DogsRetrofitInstance
    @Provides
    @Singleton
    fun retrofitInstanceDogs(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL_DOGS)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Singleton
    @Provides
    fun provideGetCats(@CatsRetrofitInstance retrofit: Retrofit): CatsService {
        return retrofit.create(CatsService::class.java)
    }
    @Singleton
    @Provides
    fun provideGetDogs(@DogsRetrofitInstance retrofit: Retrofit): DogsService {
        return retrofit.create(DogsService::class.java)
    }



    @Provides
    @Singleton
    fun provideAdsOperationsWrapper(@ApplicationContext context: Context) =
        AdsOperator(context)
}