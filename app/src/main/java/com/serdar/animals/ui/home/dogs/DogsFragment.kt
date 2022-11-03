package com.serdar.animals.ui.home.dogs

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
        getDogImages()
        return binding.root
    }

    private fun getDogImages() {
        dogsViewmodel.dogsResponse.observe(requireActivity()) { dogs ->

            val url = dogs[0].url.toString()

            Glide
                .with(this)
                .load(url)
                .into(binding.dogsImages)


        }
    }


}