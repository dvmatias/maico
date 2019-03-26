package com.matias.maico.screens.splash

import android.util.Log
import com.matias.maico.common.mvp.BasePresenterImpl

class SplashPresenter(private var checkNetworkStatusInteractor: CheckNetworkStatusInteractor)
    : BasePresenterImpl<SplashContract.View>(), SplashContract.Presenter, CheckNetworkStatusInteractor.Listener {

    override fun internetConnected() {
        showLoading(false)
        Log.d("SplashPresenter", "MABEL - Internet connected.")
    }

    override fun internetNotConnected() {
        showLoading(false)
        Log.d("SplashPresenter", "MABEL - Internet NOT connected.")
    }

    override fun checkInternetConnectionStatus() {
        showLoading(true)
        checkNetworkStatusInteractor.checkInternetConnectionStatus(this)
    }

    private fun showLoading(show: Boolean) {
        if (isBound) {
            view?.showLoading(show)
        }
    }
}