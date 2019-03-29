package com.matias.maico.screens.validatecredentials

import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface ValidateCredentialsContract {

    interface View: BaseView {

        fun animateUserPhoneView()
        fun goToChooseCountryScreen() // Launch ChooseCountryActivity.
        fun setCountry(countryName: String, countryFlagUrl: String, countryPrefix: String) // set selected (or default) country.
        fun showEnterPinView() // Show the view for entering the user's pin code.
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.
        fun showWrongCountryInlineError() // Display error for entered country.
        fun showWrongNumberInlineError() // Display error for entered number.

    }

    interface Presenter: BasePresenter<View> {

        fun checkInternetConnectionStatus() // Verify Internet connection status.
        fun validatePhoneNumber() // Verify if the phone number is correct

    }

}