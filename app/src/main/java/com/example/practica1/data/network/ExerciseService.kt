package com.example.practica1.data.network

import android.util.Log
import com.example.practica1.core.RetrofitHelper
import com.example.practica1.data.model.ExerciseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getExercises():List<ExerciseModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ExerciseApiClient::class.java).getAllExercises()
            response.body() ?: emptyList()
        }

    }
}