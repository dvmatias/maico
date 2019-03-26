package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.common.dependencyinjection.utils.InternetConnectivityManager
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule {

    @Provides
    fun getInternetConnectivityManager(): InternetConnectivityManager
            = InternetConnectivityManager()

}