package com.matias.maico.screens.splash

import android.util.Log
import com.matias.maico.common.mvp.BasePresenterImpl

class SplashPresenter(private var checkNetworkStatusInteractor: CheckNetworkStatusInteractor)
    : BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter, CheckNetworkStatusInteractor.Listener {

    override fun internetConnected() {
        Log.d("asdasd", "MABEL - Internet connected.")
    }

    override fun internetNotConnected() {
        Log.d("asdasd", "MABEL - Internet NOT connected.")
    }

    override fun checkInternetConnectionStatus() {
        if (isBound) {
            view?.showLoading(true)
            checkNetworkStatusInteractor.checkInternetConnectionStatus(this)
        }
    }
}