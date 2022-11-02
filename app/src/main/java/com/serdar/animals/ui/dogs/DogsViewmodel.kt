package com.serdar.animals.ui.dogs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.animals.model.Dogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewmodel
@Inject constructor(private val repository: DogsRepository) : ViewModel() {


    private val _response = MutableLiveData<Dogs>()
    val dogsResponse: LiveData<Dogs>
        get() = _response


    init {
        getDogs()
    }

    private fun getDogs() = viewModelScope.launch {
        repository.getDogs().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

}