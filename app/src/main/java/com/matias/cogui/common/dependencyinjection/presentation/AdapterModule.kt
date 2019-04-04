package com.matias.cogui.common.dependencyinjection.presentation

import android.content.Context
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.matias.cogui.common.utils.ImageLoader
import com.matias.cogui.screens.choosecountry.CountryListAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    fun getCountryListAdapter(
        context: Context,
        imageLoader: ImageLoader,
        phoneNumberUtil: PhoneNumberUtil
    ): CountryListAdapter =
        if (context is CountryListAdapter.ClickListener) CountryListAdapter(
            context as CountryListAdapter.ClickListener,
            imageLoader,
            phoneNumberUtil
        )
        else throw ExceptionInInitializerError("Calling Activity mus implement CountryListAdapter.ClickListener interface.")

}