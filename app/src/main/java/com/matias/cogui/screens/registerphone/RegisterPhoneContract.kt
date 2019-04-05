package com.matias.cogui.screens.registerphone

import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BasePresenter
import com.matias.cogui.common.mvp.BaseView

interface RegisterPhoneContract {

    interface View : BaseView {

        fun goToValidatePhoneScreen() // TODO
        fun setSelectedCountry(country: Country) // set selected (or default) country.
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.
        fun showSelectedCountry()
        fun showWrongCountryDialog() // Display error for entered country.
        fun showWrongNumberDialog() // Display error for entered number.

    }

    interface Presenter : BasePresenter<View> {

        fun checkInternetConnectionStatus() // Verify Internet connection status.
        fun validateCountry() // Verify if the selected country number is correct.
        fun validatePhoneNumber(nameCode: String, number: String) // Verify if the phone number is correct.

    }

}