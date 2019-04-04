package com.matias.cogui.screens.registerphone

import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BasePresenter
import com.matias.cogui.common.mvp.BaseView

interface RegisterPhoneContract {

    interface View : BaseView {

        fun goToChooseCountryScreen() // Launch ChooseCountryActivity.
        fun goToValidatePhoneScreen() // TODO
        fun onGetStartedClick()
        fun setSelectedCountry(country: Country) // set selected (or default) country.
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.
        fun showGetStartButton(show: Boolean) // Show/Hide "Get Started" button.
        fun showSelectedCountry()
        fun showTermsAndConditions(show: Boolean) // Show the view for terms and conditions.
        fun showWrongCountryInlineError() // Display error for entered country.
        fun showWrongNumberInlineError() // Display error for entered number.

    }

    interface Presenter : BasePresenter<View> {

        fun checkInternetConnectionStatus() // Verify Internet connection status.
        fun validateCountry() // Verify if the selected country number is correct.
        fun validatePhoneNumber(nameCode: String, number: String) // Verify if the phone number is correct.

    }

}