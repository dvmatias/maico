package com.matias.cogui.screens.registerphone

import com.matias.cogui.common.mvp.BasePresenterImpl

class RegisterPhonePresenter(v: RegisterPhoneContract.View) : BasePresenterImpl<RegisterPhoneContract.View>(), RegisterPhoneContract.Presenter {

    init {
        bind(v)
    }

    override fun checkInternetConnectionStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validateCountry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validatePhoneNumber(code: String, number: String) {
        // TODO
    }

}