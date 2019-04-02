package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.choosecountry.ChooseCountryActivity
import com.matias.maico.screens.splash.SplashActivity
import com.matias.maico.screens.validatecredentials.ValidateCredentialsActivity
import dagger.Subcomponent

@Subcomponent(
	modules = [
		PresentationModule::class,
		PresenterModule::class,
		InteractorModule::class,
		AdapterModule::class
	]
)
interface PresentationComponent {

	fun inject(splashActivity: SplashActivity)
	fun inject(validateCredentialsActivity: ValidateCredentialsActivity)
	fun inject(chooseCountryActivity: ChooseCountryActivity)

}