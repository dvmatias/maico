package com.matias.maico.screens.splash

import com.matias.maico.common.mvp.BasePresenterImpl

class SplashPresenter(
    v: SplashContract.View,
    private var checkNetworkStatusInteractor: CheckNetworkStatusInteractor,
    private var checkCredentialsInteractor: CheckCredentialsInteractor
) : BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter, CheckNetworkStatusInteractor.Listener,
    CheckCredentialsInteractor.Listener {

    init {
        bind(v)
    }

    override fun checkCredentials() {
        checkCredentialsInteractor.checkCredentials(this)
    }

    override fun checkInternetConnectionStatus() {
        checkNetworkStatusInteractor.checkInternetConnectionStatus(this)
    }

    /*
     * CheckCredentialsInteractor interface implementation.
     */

    override fun credentialsValid() {
        this.view?.gotToHomeScreen()
    }

    override fun credentialsInvalid() {
        this.view?.goToValidateCredentialsScreen()
    }

    /*
     * CheckNetworkStatusInteractor interface implementation.
     */

    override fun internetConnected() {
        this.view?.checkCredentials()
    }

    override fun internetNotConnected() {
        this.view?.showNoConnectionErrorDialog()
    }
}