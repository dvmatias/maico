package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.common.mvp.BaseView
import com.matias.maico.screens.choosecountry.ChooseCountryContract
import com.matias.maico.screens.choosecountry.ChooseCountryPresenter
import com.matias.maico.screens.choosecountry.FetchCountryListInteractor
import com.matias.maico.screens.splash.CheckCredentialsInteractor
import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
import com.matias.maico.screens.splash.SplashContract
import com.matias.maico.screens.splash.SplashPresenter
import com.matias.maico.screens.validatecredentials.ValidateCredentialsContract
import com.matias.maico.screens.validatecredentials.ValidateCredentialsPresenter
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