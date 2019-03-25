package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
import com.matias.maico.screens.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun getSplashPresenter(checkNetworkStatusInteractor: CheckNetworkStatusInteractor): SplashPresenter
            = SplashPresenter(checkNetworkStatusInteractor)

}
