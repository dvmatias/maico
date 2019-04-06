package com.matias.cogui.screens.registerphone

import android.os.Handler
import com.matias.cogui.common.mvp.BasePresenterImpl
import com.matias.cogui.common.utils.managers.PhoneManager

class RegisterPhonePresenter(
	v: RegisterPhoneContract.View,
	private val phoneManager: PhoneManager
) :
	BasePresenterImpl<RegisterPhoneContract.View>(), RegisterPhoneContract.Presenter {

	private var countryNameCode: String = "XX"
	private var phoneNumber: String = ""

	/**
	 * Init the presenter.
	 */
	init {
		bind(v)
	}

	/**
	 * Check Internet connection status. This should be called before registering the user's
	 * phone number.
	 */
	override fun checkInternetConnectionStatus() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	/**
	 * It receives [countryNameCode] and [phoneNumber] and validate for they validity. If booth
	 * are valid values, then it try to register the user's phone number. For non valid fields
	 * it call [view] methods to show corresponding dialog error.
	 */
	override fun validatePhoneNumber(countryNameCode: String, phoneNumber: String) {
		this.countryNameCode = countryNameCode
		this.phoneNumber = phoneNumber

		if (!isValidCountry()) {// INVALID country.
			view?.showWrongCountryDialog()
		} else if (!isValidPhoneNumber()) // VALID country - INVALID number
			view?.showWrongNumberDialog()
		else // VALID country - VALID number
			registerPhoneNumber()
	}

	/**
	 * It uses [phoneManager] to validate the [countryNameCode].
	 */
	override fun isValidCountry(): Boolean {
		return phoneManager.isValidCountryName(countryNameCode)
	}

	/**
	 * It uses [phoneManager] to validate the [phoneNumber] along with the [countryNameCode].
	 * It shall not be called if the [countryNameCode] isn't valid.
	 */
	override fun isValidPhoneNumber(): Boolean {
		return phoneManager.isValidNumber(phoneNumber, countryNameCode)
	}

	/**
	 * It is meant to register user's phone number. It must came back with a PIN number in
	 * order to verify in further registrations steps.
	 */
	override fun registerPhoneNumber() {
		view?.showLoadingDialog(true)
		// TODO replace for phone registration logic.
		Handler().postDelayed({
			view?.showLoadingDialog(false)
			view?.goToValidatePhoneScreen()
		}, 3000)
	}
}