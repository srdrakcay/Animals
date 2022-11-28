package com.serdar.animals.ui.dogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.serdar.animals.data.wrapper.AdsOperator
import com.serdar.animals.databinding.FragmentDogsBinding
import com.serdar.animals.utils.loadUrl
import com.serdar.animals.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.serdar.animals.R

@AndroidEntryPoint
class DogsFragment : Fragment(R.layout.fragment_dogs) {

    @Inject
    lateinit var adsOperator: AdsOperator

    private val viewModel: DogsViewModel by viewModels()

    private val binding by viewBinding(FragmentDogsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAds()
        initViews()
        getObserveDog()
    }

    private fun initViews() = with(binding) {
        favoriteDogs.setOnClickListener {
            viewModel.getDogs()
        }
        refreshDogs.setOnClickListener {
            viewModel.getDogs()
        }
    }

    private fun getObserveDog() = with(binding) {
        viewModel.dogsUrl.observe(viewLifecycleOwner) { dogUrl ->
            dogsImages.loadUrl(dogUrl)
        }
    }

    private fun loadAds() = with(binding.adViewDogs) {
        val request = adsOperator.showBannerAds()
        loadAd(request)
    }

}