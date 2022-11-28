package com.serdar.animals.ui.cats

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.serdar.animals.data.wrapper.AdsOperator
import com.serdar.animals.databinding.FragmentCatsBinding
import com.serdar.animals.utils.loadUrl
import com.serdar.animals.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

import com.serdar.animals.R

@AndroidEntryPoint
class CatsFragment : Fragment(R.layout.fragment_cats) {

    @Inject
    lateinit var adsOperator: AdsOperator

    private val viewModel: CatsViewmModel by viewModels()

    private val binding by viewBinding(FragmentCatsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catsAds()
        initViews()
        getObserveCats()
    }

    private fun initViews() {
        with(binding) {
            favorite.setOnClickListener {
                viewModel.getCats()
            }
            refresh.setOnClickListener {
                viewModel.getCats()
            }
        }
    }

    private fun getObserveCats() {
        viewModel.catsUrl.observe(viewLifecycleOwner) { catUrl ->
            binding.catsImages.loadUrl(catUrl)
        }
    }

    private fun catsAds() {
        val request = adsOperator.showBannerAds()
        binding.adView.loadAd(request)
    }

}


