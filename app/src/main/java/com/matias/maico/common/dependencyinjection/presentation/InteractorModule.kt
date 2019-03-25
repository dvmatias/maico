package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun getCheckNetworkStatusInteractor(): CheckNetworkStatusInteractor = CheckNetworkStatusInteractor()

}