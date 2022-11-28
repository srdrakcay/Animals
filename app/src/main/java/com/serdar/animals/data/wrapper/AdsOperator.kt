package com.serdar.animals.data.wrapper

import android.content.Context
import com.google.android.gms.ads.*
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class AdsOperator @Inject constructor ( @ApplicationContext private val context: Context){

    fun initMobileAds() {
        MobileAds.initialize(context)
    }

    fun showBannerAds(): AdRequest = AdRequest.Builder().build()


    companion object {
        private const val NATIVE_ADS_ID = "ca-app-pub-3940256099942544/2247696110"
    }
}
