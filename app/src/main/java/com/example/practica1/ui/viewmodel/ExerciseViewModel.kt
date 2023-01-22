package com.example.practica1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica1.data.model.ExerciseModel
import com.example.practica1.domain.GetExercisesUseCase
import kotlinx.coroutines.launch

class ExerciseViewModel :ViewModel() {
     val exerciseList = MutableLiveData<List<ExerciseModel>?>()
     val loader = MutableLiveData<Boolean>()

    var getExercisesUseCase = GetExercisesUseCase()

    fun onCreate(){
        viewModelScope.launch {
            val result = getExercisesUseCase()

            if(result.isNotEmpty()){
                exerciseList.postValue(result)
                loader.postValue(false)
            }
        }
    }
}