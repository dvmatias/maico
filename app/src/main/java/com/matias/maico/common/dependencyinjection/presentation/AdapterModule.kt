package com.matias.maico.common.dependencyinjection.presentation

import android.content.Context
import com.matias.maico.common.utils.ImageLoader
import com.matias.maico.screens.choosecountryscreen.CountryListAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

	@Provides
	fun getCountryListAdapter(context: Context, imageLoader: ImageLoader): CountryListAdapter =
		if (context is CountryListAdapter.ClickListener) CountryListAdapter(context as CountryListAdapter.ClickListener, imageLoader)
		else throw ExceptionInInitializerError("Calling Activity mus implement CountryListAdapter.ClickListener interface.")

}