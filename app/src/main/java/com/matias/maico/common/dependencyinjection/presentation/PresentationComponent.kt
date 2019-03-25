package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(
    modules = [PresentationModule::class,
        PresentersModule::class]
)
interface PresentationComponent {

    fun inject(splashActivity: SplashActivity)

}