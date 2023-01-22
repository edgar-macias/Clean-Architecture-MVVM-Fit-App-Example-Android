package com.example.practica1.data

import com.example.practica1.data.model.ExerciseModel
import com.example.practica1.data.model.ExerciseProvider
import com.example.practica1.data.network.ExerciseService

class ExerciseRepository {

    private val api = ExerciseService()

    suspend fun getAllExercises():List<ExerciseModel>{
        val response = api.getExercises()
        ExerciseProvider.exercises = response
        return response
    }
}