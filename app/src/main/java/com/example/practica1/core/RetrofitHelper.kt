package com.example.practica1.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val API_URL = "https://private-26b62-firstapiemp.apiary-mock.com/"

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}