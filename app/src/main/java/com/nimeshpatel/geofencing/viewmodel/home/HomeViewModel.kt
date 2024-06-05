package com.nimeshpatel.geofencing.viewmodel.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Nimesh Patel on 05-Jun-24.
 * Purpose:
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val applicationContext: Lazy<Context>
) : ViewModel() {
    private val _isSplashScreenLoading = MutableStateFlow(true)
    val isSplashScreenLoading: StateFlow<Boolean>
        get() = _isSplashScreenLoading


    init {

        viewModelScope.launch {
            delay(1000)
            _isSplashScreenLoading.emit(false)
        }
    }


}