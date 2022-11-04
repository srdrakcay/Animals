package com.serdar.animals.ui.cats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.gms.ads.*
import com.serdar.animals.data.wrapper.AdsOperator
import com.serdar.animals.databinding.FragmentCatsBinding
import com.serdar.animals.ui.cats.CatsViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatsFragment : Fragment() {
    @Inject lateinit var adsOperator: AdsOperator
    private val catsViewmodel: CatsViewmodel by viewModels()
    private lateinit var binding: FragmentCatsBinding
    lateinit var mAdView : AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatsBinding.inflate(layoutInflater)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catsAds()
        try {
            with(binding) {
                favorite.setOnClickListener {
                    catsViewmodel.getCats()
                }
                refresh.setOnClickListener {
                    catsViewmodel.getCats()
                }
            }
        } catch (e: Exception) {

        }
        getObserveCats()
    }
    private fun getObserveCats() {
        catsViewmodel.catsResponse.observe(requireActivity()) { cats ->

            val url = cats[0].url.toString()

            Glide
                .with(requireActivity())
                .load(url)
                .into(binding.catsImages)

        }
    }
    private fun catsAds(){
        val request = adsOperator.showBannerAds()
       binding.adView.loadAd(request)
        binding.adView.adListener = object : AdListener() {

            }
        }


    }


