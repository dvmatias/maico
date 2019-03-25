package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class PresentersModule {

    @Provides
    fun getSplashPresenter(): SplashPresenter = SplashPresenter()

}
