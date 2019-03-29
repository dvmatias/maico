package com.matias.maico.screens.validatecredentials

import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface ValidateCredentialsContract {

    interface View: BaseView {

        fun animateUserPhoneView()
        fun goToChooseCountryScreen() // Launch ChooseCountryActivity.
        fun goToHomeScreen() // Launch HomeScreenActivity.
        fun setCountry(countryName: String, countryFlagUrl: String, countryPrefix: String) // set selected (or default) country.
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.
        fun showGetStartButton(show: Boolean) // Show/Hide "Get Started" button.
        fun showTermsAndConditions() // Show the view for terms and conditions.
        fun showWrongCountryInlineError() // Display error for entered country.
        fun showWrongNumberInlineError() // Display error for entered number.

    }

    interface Presenter: BasePresenter<View> {

        fun checkInternetConnectionStatus() // Verify Internet connection status.
        fun validateCountry() // Verify if the selected country number is correct.
        fun validatePhoneNumber() // Verify if the phone number is correct.

    }

}