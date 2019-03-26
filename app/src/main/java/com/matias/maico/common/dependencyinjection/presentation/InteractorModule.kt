package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.common.dependencyinjection.utils.InternetConnectivityManager
import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun getCheckNetworkStatusInteractor(internetConnectivityManager: InternetConnectivityManager): CheckNetworkStatusInteractor
            = CheckNetworkStatusInteractor(internetConnectivityManager)

}