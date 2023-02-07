package com.example.practica1.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.practica1.R
import com.example.practica1.data.model.ExerciseModel
import com.example.practica1.databinding.FragmentDetailBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private var exercise:ExerciseModel? = null
    private val args:DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val supportMapFragment:SupportMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        supportMapFragment.getMapAsync{
            it.mapType = GoogleMap.MAP_TYPE_NORMAL

            it.clear()

            val googlePlex = CameraPosition.builder()
                .target(LatLng(37.42,-122.086))
                .zoom(10f)
                .bearing(0f)
                .tilt(45f)
                .build()

            it.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex),10000,null)

            it.addMarker(
                MarkerOptions()
                    .position(LatLng(37.42,-122.086))
                    .title("Closer Gym"))
        }
        exercise = args.exercise
        (activity as AppCompatActivity).supportActionBar?.title = exercise!!.name
        binding=FragmentDetailBinding.bind(view)
        Glide.with(view)
            .load(exercise!!.imagePath)
            .apply(RequestOptions().override(300,300))
            .into(binding.ivExercise)
        binding.tvExerciseName.text = getString(R.string.exerciseName, exercise!!.name)
        binding.tvMusculo.text = getString(R.string.musculo, exercise!!.muscle)
        binding.tvDificutad.text = getString(R.string.dificultad,exercise!!.defficulty)
        binding.tvInstrucciones.text = getString(R.string.instrucciones,exercise!!.instructions)
    }


}