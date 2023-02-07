package com.example.practica1.domain

import com.example.practica1.data.repository.ExerciseRepository
import com.example.practica1.data.model.ExerciseModel

class GetExercisesUseCase {

    private val repository = ExerciseRepository()

    suspend operator fun invoke():List<ExerciseModel> = repository.getAllExercises()
}