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
        val valid = phoneManager.isValidNumber(number, nameCode)
        println("*** MABEL $valid")
    }

}