package com.example.practica1.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica1.R
import com.example.practica1.databinding.FragmentListBinding
import com.example.practica1.ui.viewmodel.ExerciseViewModel
import com.example.practica1.ui.views.adapters.ExerciseAdapter


class ListFragment : Fragment(R.layout.fragment_list) {

    private val exerciseViewModel: ExerciseViewModel by viewModels()

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: ExerciseAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exerciseViewModel.onCreate()

        binding = FragmentListBinding.bind(view)
        binding.refresh.setOnRefreshListener {
            exerciseViewModel.onCreate()
            exerciseViewModel.exerciseList.observe(viewLifecycleOwner){
                if (it != null) {
                    this.binding.refresh.isRefreshing = it.isEmpty()
                }
            }
        }

        adapter = ExerciseAdapter(emptyList())
        adapter.onItemClick = {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }

        binding.rvExercises.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        binding.rvExercises.adapter = adapter

        exerciseViewModel.exerciseList.observe(viewLifecycleOwner){
            if (!it.isNullOrEmpty()) {
                adapter.updateItems(it)
            }else{
                adapter.updateItems(emptyList())
            }
        }

        exerciseViewModel.loader.observe(viewLifecycleOwner){
            binding.loader.visibility = if(it) View.VISIBLE else View.GONE
        }
    }
}