package com.matias.cogui.common.dependencyinjection.presentation

import com.matias.cogui.common.utils.managers.InternetConnectivityManager
import com.matias.cogui.common.utils.managers.SharedPreferencesManager
import com.matias.cogui.screens.choosecountry.FetchCountryListInteractor
import com.matias.cogui.screens.splash.CheckCredentialsInteractor
import com.matias.cogui.screens.splash.CheckNetworkStatusInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

	@Provides
	fun getCheckNetworkStatusInteractor(internetConnectivityManager: InternetConnectivityManager): CheckNetworkStatusInteractor =
		CheckNetworkStatusInteractor(internetConnectivityManager)

	@Provides
	fun getCheckCredentialsInteractor(sharedPreferencesManager: SharedPreferencesManager): CheckCredentialsInteractor =
		CheckCredentialsInteractor(sharedPreferencesManager)

	@Provides
	fun getFetchCountryListInteractor(): FetchCountryListInteractor =
		FetchCountryListInteractor()

}