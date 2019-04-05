package com.matias.cogui.screens.registerphone

import com.matias.cogui.common.mvp.BasePresenterImpl
import com.matias.cogui.common.utils.managers.PhoneManager

class RegisterPhonePresenter(v: RegisterPhoneContract.View, private val phoneManager: PhoneManager) :
    BasePresenterImpl<RegisterPhoneContract.View>(), RegisterPhoneContract.Presenter {

    init {
        bind(v)
    }

    override fun checkInternetConnectionStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validateCountry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validatePhoneNumber(nameCode: String, number: String) {
        val validCountry = phoneManager.isValidCountryName(nameCode)
        val validNumber = if (validCountry) phoneManager.isValidNumber(number, nameCode) else false

        if (!validCountry) // INVALID country.
            view?.showWrongCountryDialog()
        else {
            if (!validNumber) // VALID country - INVALID number
                view?.showWrongNumberDialog()
            else // VALID country - VALID number
                view?.goToValidatePhoneScreen()
        }
    }

}