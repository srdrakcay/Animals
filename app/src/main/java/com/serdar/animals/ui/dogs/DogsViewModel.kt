package com.serdar.animals.ui.dogs

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.animals.data.repository.DogsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsViewModel
@Inject constructor(private val repository: DogsRepository) : ViewModel() {


    private val _response = MutableLiveData<String>()
    val dogsUrl: LiveData<String>
        get() = _response


    init {
        getDogs()
    }

     fun getDogs() = viewModelScope.launch {
        repository.getDogs().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body()?.firstOrNull()?.url.toString())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

}