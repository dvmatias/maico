package com.matias.maico.common.dependencyinjection.presentation

import android.content.Context
import com.matias.maico.common.dependencyinjection.utils.InternetConnectivityManager
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule(val context: Context) {

    @Provides
    fun getInternetConnectivityManager(): InternetConnectivityManager
            = InternetConnectivityManager(context)

}