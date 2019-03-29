package com.matias.maico.screens.splash

import android.os.Handler
import com.matias.maico.common.dependencyinjection.utils.InternetConnectivityManager

class CheckNetworkStatusInteractor(private var internetConnectivityManager: InternetConnectivityManager) {

    interface Listener {
        fun internetConnected()
        fun internetNotConnected()
    }

    fun checkInternetConnectionStatus(listener: Listener) {
        Handler().postDelayed({
            if (internetConnectivityManager.checkInternetConnectionStatus()) listener.internetConnected()
            else listener.internetNotConnected()
        }, 1000)
    }

}