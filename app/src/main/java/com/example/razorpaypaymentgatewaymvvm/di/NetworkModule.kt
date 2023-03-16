package com.example.razorpaypaymentgatewaymvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    //retrofit object.....
    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.razorpay.com/v1").build()
    }

   /* //create user api object.......
    @Singleton
    @Provides
    fun providesUserAPI(retrofit: Retrofit) : UserAPI{
        return retrofit.create(UserAPI::class.java)
    }*/
}