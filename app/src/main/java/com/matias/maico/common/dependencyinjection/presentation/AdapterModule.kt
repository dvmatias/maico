package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.screens.choosecountryscreen.CountryListAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

	@Provides
	fun getCountryListAdapter(): CountryListAdapter =
			CountryListAdapter()

}