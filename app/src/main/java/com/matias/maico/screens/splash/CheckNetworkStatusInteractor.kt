package com.matias.maico.screens.splash

import android.util.Log

class CheckNetworkStatusInteractor {

    interface Listener {
        fun internetConnected()
        fun internetNotConnected()
    }

    fun checkInternetConnectionStatus(listener: Listener) {
        Log.d("CheckNetworkStatusIn", "MABEL - Interactor method called.")


//        if (internetConnectivityManager.checkInternetConnectionStatus()) listener.internetConnected()
//        else listener.internetNotConnected()
    }

}