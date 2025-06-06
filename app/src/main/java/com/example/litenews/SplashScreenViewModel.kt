package com.example.litenews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import javax.security.auth.callback.Callback

class SplashScreenViewModel(): ViewModel() {
    fun wait(callback: ()->(Unit)) {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            callback()
        }

    }
}