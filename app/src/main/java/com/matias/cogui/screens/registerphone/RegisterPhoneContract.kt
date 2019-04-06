package com.matias.cogui.screens.registerphone

import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BasePresenter
import com.matias.cogui.common.mvp.BaseView

interface RegisterPhoneContract {

	interface View : BaseView {

		fun goToEnterPhoneScreen()
		fun goToValidatePhoneScreen()
		fun setSelectedCountry(country: Country)
		fun showLoadingDialog(show: Boolean)
		fun showNoConnectionErrorDialog()
		fun showSelectedCountry()
		fun showWrongCountryDialog()
		fun showWrongNumberDialog()

	}

	interface Presenter : BasePresenter<View> {

		fun checkInternetConnectionStatus()
		fun validatePhoneNumber(countryNameCode: String, phoneNumber: String)
		fun isValidPhoneNumber(): Boolean
		fun isValidCountry(): Boolean
		fun registerPhoneNumber()

	}

}