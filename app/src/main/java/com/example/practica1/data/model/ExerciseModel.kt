package com.example.practica1.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExerciseModel(
    @SerializedName("id")
    val id:String,
    @SerializedName("nombre")
    val name:String,
    @SerializedName("musculo")
    val muscle:String,
    @SerializedName("dificultad")
    val defficulty:String,
    @SerializedName("instrucciones")
    val instructions:String,
    @SerializedName("imagen")
    val imagePath:String
) : Parcelable
