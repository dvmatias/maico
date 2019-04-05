package com.matias.cogui.common.dependencyinjection.presentation

import com.matias.cogui.screens.choosecountry.ChooseCountryActivity
import com.matias.cogui.screens.registerphone.fragments.EnterPhoneFragment
import com.matias.cogui.screens.splash.SplashActivity
import com.matias.cogui.screens.registerphone.RegisterPhoneActivity
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
	fun inject(registerPhoneActivity: RegisterPhoneActivity)
	fun inject(enterPhoneFragment: EnterPhoneFragment)
	fun inject(chooseCountryActivity: ChooseCountryActivity)

}