package com.example.practica1.data.network

import com.example.practica1.data.model.ExerciseModel
import retrofit2.Response
import retrofit2.http.GET

interface ExerciseApiClient {
    @GET("/ejercicios")
    suspend fun getAllExercises():Response<List<ExerciseModel>>
}