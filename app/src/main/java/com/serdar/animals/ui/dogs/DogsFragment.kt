package com.serdar.animals.ui.dogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdListener
import com.serdar.animals.data.wrapper.AdsOperator
import com.serdar.animals.databinding.FragmentDogsBinding
import com.serdar.animals.ui.dogs.DogsViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DogsFragment : Fragment() {
    @Inject lateinit var adsOperator: AdsOperator
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
        dogsAds()
        try {
            with(binding){
                favoriteDogs.setOnClickListener {
                    dogsViewmodel.getDogs()
                }
                refreshDogs.setOnClickListener {
                    dogsViewmodel.getDogs()
                }
        }

        }catch (e:Exception){

        }
        getObserveDog()
    }

    private fun getObserveDog() {
        dogsViewmodel.dogsResponse.observe(requireActivity()) { dogs ->

            val url = dogs[0].url.toString()

            Glide
                .with(requireActivity())
                .load(url)
                .into(binding.dogsImages)


        }
    }
    private fun dogsAds(){
        val request = adsOperator.showBannerAds()
        binding.adViewDogs.loadAd(request)
        binding.adViewDogs.adListener = object : AdListener() {

        }
    }


}