package com.matias.cogui.screens.splash

import com.matias.cogui.common.mvp.BasePresenter
import com.matias.cogui.common.mvp.BaseView

interface SplashContract {

    interface View: BaseView {

        fun askUserPermissionFineLocation()
        fun checkCredentials() // Verify if the user his logged.
        fun checkInternetConnectionStatus() // Ask presenter to check Internet connection status.
        fun gotToHomeScreen() // Launch HomeActivity.
        fun goToRegisterPhoneScreen() // Launch RegisterPhoneActivity.`
        fun showNeedPermissionDialog()
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.

    }

    interface Presenter: BasePresenter<View> {

        fun checkCredentials() // Verify if the user his logged.
        fun checkInternetConnectionStatus() // Verify Internet connection status.

    }

}