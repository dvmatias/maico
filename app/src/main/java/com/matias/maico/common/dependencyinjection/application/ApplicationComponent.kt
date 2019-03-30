package com.matias.maico.common.dependencyinjection.application

import com.matias.maico.common.dependencyinjection.presentation.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkingModule::class
    ]
)
interface ApplicationComponent {

    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

}