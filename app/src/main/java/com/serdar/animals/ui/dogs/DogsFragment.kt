package com.serdar.animals.ui.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.serdar.animals.databinding.FragmentDogsBinding
import com.serdar.animals.ui.dogs.DogsViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DogsFragment : Fragment() {
    private val dogsViewmodel: DogsViewmodel by viewModels()
    private lateinit var binding: FragmentDogsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogsBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            favoriteDogs.setOnClickListener {
                dogsViewmodel.getDogs()
            }
            refreshDogs.setOnClickListener {
                dogsViewmodel.getDogs()
            }
        }
        getObserveDog()
    }

    private fun getObserveDog() {
        dogsViewmodel.dogsResponse.observe(requireActivity()) { dogs ->

            val url = dogs[0].url.toString()

            Glide
                .with(this)
                .load(url)
                .into(binding.dogsImages)


        }
    }


}