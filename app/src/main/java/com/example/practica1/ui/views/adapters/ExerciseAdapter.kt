package com.example.practica1.ui.views.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practica1.data.model.ExerciseModel
import com.example.practica1.databinding.ExerciseItemBinding

class ExerciseAdapter(private var exercises:List<ExerciseModel>): RecyclerView.Adapter<ExerciseAdapter.ViewHolder>() {

    var onItemClick:((ExerciseModel)->Unit)?=null

    class ViewHolder(private val viewBinding: ExerciseItemBinding):RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(exercise:ExerciseModel,onItemClick:((ExerciseModel)->Unit)?){
            viewBinding.tvExerciseName.text = exercise.name
            Glide.with(itemView).load(exercise.imagePath).into(viewBinding.imgExercise)
            viewBinding.aexerciseCard.setOnClickListener {
                onItemClick?.invoke(exercise)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ExerciseItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exercises[position],onItemClick)
    }

    override fun getItemCount(): Int = exercises.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<ExerciseModel>){
        exercises=newItems
        notifyDataSetChanged()
    }
}