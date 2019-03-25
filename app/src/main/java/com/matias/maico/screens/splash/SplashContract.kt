package com.matias.maico.screens.splash

import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface SplashContract {

    interface View: BaseView {
        fun checkNetworkStatus() // Ask presenter to check Internet connection status.
        fun showLoading(show: Boolean) // Show loading view.
        fun showNoConnectionError() // Show error for no Internet connection status.
        fun gotToHomeScreen() // Go launch HomeActivity.
    }

    interface Presenter: BasePresenter<View> {
        fun checkNetworkStatus() // Verify Internet connection status.
    }
}