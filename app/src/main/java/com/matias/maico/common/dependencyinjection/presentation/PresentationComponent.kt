package com.matias.maico.common.dependencyinjection.presentation

import dagger.Subcomponent

@Subcomponent(
    modules = [PresentationModule::class]
)
interface PresentationComponent {
}