package com.matias.maico.common.dependencyinjection.application

import com.matias.maico.common.dependencyinjection.presentation.PresentationComponent
import com.matias.maico.common.dependencyinjection.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class]
)
interface ApplicationComponent {

    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent

}