package com.serdar.animals.ui.cats

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serdar.animals.model.Cats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewmodel
@Inject constructor(private val repository: CatsRepository) : ViewModel() {

    private val _response = MutableLiveData<Cats>()
    val catsResponse: LiveData<Cats>
        get() = _response

    init {
        getCats()
    }

    private fun getCats() = viewModelScope.launch(Dispatchers.IO) {
        repository.getCats().let { it ->

            if (it.isSuccessful) {
                _response.postValue(it.body())
            } else {
                Log.d("tag", "getWeather Error: ${it.code()}")
            }
        }
    }

}
