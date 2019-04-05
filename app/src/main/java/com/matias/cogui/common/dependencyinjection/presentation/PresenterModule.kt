package com.matias.cogui.common.dependencyinjection.presentation

import com.matias.cogui.common.mvp.BaseView
import com.matias.cogui.screens.choosecountry.ChooseCountryContract
import com.matias.cogui.screens.choosecountry.ChooseCountryPresenter
import com.matias.cogui.screens.choosecountry.FetchCountryListInteractor
import com.matias.cogui.screens.splash.CheckCredentialsInteractor
import com.matias.cogui.screens.splash.CheckNetworkStatusInteractor
import com.matias.cogui.screens.splash.SplashContract
import com.matias.cogui.screens.splash.SplashPresenter
import com.matias.cogui.screens.validatecredentials.ValidateCredentialsContract
import com.matias.cogui.screens.validatecredentials.ValidateCredentialsPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

	@Provides
	fun getSplashPresenter(
			view: BaseView,
			checkNetworkStatusInteractor: CheckNetworkStatusInteractor,
			checkCredentialsInteractor: CheckCredentialsInteractor
	): SplashPresenter =
			SplashPresenter(view as SplashContract.View, checkNetworkStatusInteractor, checkCredentialsInteractor)

	@Provides
	fun getValidateCredentialsPresenter(view: BaseView) = ValidateCredentialsPresenter(view as ValidateCredentialsContract.View)

	@Provides
	fun getChooseCountryPresenter(
			view: BaseView,
			fetchCountryListInteractor: FetchCountryListInteractor
	): ChooseCountryPresenter =
		ChooseCountryPresenter(
			view as ChooseCountryContract.View,
			fetchCountryListInteractor
		)
}