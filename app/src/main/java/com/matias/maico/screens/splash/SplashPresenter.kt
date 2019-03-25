package com.matias.maico.screens.splash

import com.matias.maico.common.mvp.BasePresenterImpl

class SplashPresenter: BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter {

    override fun checkNetworkStatus() {
        // TODO check network status.
    }
}