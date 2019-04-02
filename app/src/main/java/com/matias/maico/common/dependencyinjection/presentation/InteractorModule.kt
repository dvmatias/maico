package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.common.dependencyinjection.utils.InternetConnectivityManager
import com.matias.maico.common.managers.SharedPreferencesManager
import com.matias.maico.screens.choosecountryscreen.FetchCountryListInteractor
import com.matias.maico.screens.splash.CheckCredentialsInteractor
import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
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
	fun getFetchCountryListInteractor(): FetchCountryListInteractor = FetchCountryListInteractor()

}