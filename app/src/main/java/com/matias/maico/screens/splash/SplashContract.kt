package com.matias.maico.screens.splash

import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface SplashContract {

    interface View: BaseView {

        fun askUserPermissionFineLocation()
        fun checkCredentials() // Verify if the user his logged.
        fun checkInternetConnectionStatus() // Ask presenter to check Internet connection status.
        fun gotToHomeScreen() // Launch HomeActivity.
        fun goToValidateCredentialsScreen() // Launch ValidateCredentialsActivity.`
        fun showNeedPermissionDialog()
        fun showNoConnectionErrorDialog() // Show error for no Internet connection status.

    }

    interface Presenter: BasePresenter<View> {

        fun checkCredentials() // Verify if the user his logged.
        fun checkInternetConnectionStatus() // Verify Internet connection status.

    }

}