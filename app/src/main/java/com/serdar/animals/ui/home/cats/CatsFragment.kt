package com.serdar.animals.ui.home.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.serdar.animals.databinding.FragmentCatsBinding
import com.serdar.animals.ui.cats.CatsViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatsFragment : Fragment() {
    private val catsViewmodel: CatsViewmodel by viewModels()
    private lateinit var binding: FragmentCatsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatsBinding.inflate(layoutInflater)

        getImage()

        return binding.root


    }

    private fun getImage() {
        catsViewmodel.catsResponse.observe(requireActivity()) { cats ->

            val url = cats[0].url.toString()

            Glide
                .with(this)
                .load(url)
                .into(binding.catsImages)


        }
    }

}