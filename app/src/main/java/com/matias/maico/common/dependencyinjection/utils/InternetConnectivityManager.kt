package com.matias.maico.common.dependencyinjection.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


class InternetConnectivityManager(val context: Context) {

    fun checkInternetConnectionStatus(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo

        return activeNetwork?.isConnectedOrConnecting == true
    }
}