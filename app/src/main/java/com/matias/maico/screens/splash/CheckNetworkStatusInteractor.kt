package com.matias.maico.screens.splash

class CheckNetworkStatusInteractor(listener: Listener) {

    interface Listener {
        fun internetConnected()
        fun internetNotConnected()
    }

    fun checkInternetConnectionStatus(listener: Listener) {
        // TODO check Internet connection status.
    }

}