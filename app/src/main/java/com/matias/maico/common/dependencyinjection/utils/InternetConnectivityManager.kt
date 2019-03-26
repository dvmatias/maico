package com.matias.maico.common.dependencyinjection.utils


class InternetConnectivityManager {

    fun checkInternetConnectionStatus(): Boolean {
//        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
//
//        return activeNetwork?.isConnectedOrConnecting == true
        return false
    }
}