package com.matias.maico.screens.splash

import com.matias.maico.common.mvp.BasePresenterImpl

class SplashPresenter(private var checkNetworkStatusInteractor: CheckNetworkStatusInteractor)
    : BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter {

    override fun checkNetworkStatus() {
        if (isBound) {
            view?.showLoading(true)
        }
    }
}