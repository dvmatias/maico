package com.matias.maico.screens.validatecredentials

import com.matias.maico.common.mvp.BasePresenterImpl

class ValidateCredentialsPresenter(v: ValidateCredentialsContract.View) : BasePresenterImpl<ValidateCredentialsContract.View>(), ValidateCredentialsContract.Presenter {
    override fun checkInternetConnectionStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    override fun validateCountry() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun validatePhoneNumber() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {
        bind(v)
    }

}