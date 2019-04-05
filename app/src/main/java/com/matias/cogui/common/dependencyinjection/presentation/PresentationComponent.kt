package com.matias.cogui.common.dependencyinjection.presentation

import com.matias.cogui.screens.choosecountry.ChooseCountryActivity
import com.matias.cogui.screens.splash.SplashActivity
import com.matias.cogui.screens.validatecredentials.ValidateCredentialsActivity
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