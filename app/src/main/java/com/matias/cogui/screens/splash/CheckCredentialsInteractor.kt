package com.matias.cogui.screens.splash

import com.matias.cogui.common.managers.SharedPreferencesManager

class CheckCredentialsInteractor(private var sharedPreferencesManager: SharedPreferencesManager) {

    interface Listener {
        fun credentialsValid()
        fun credentialsInvalid()
    }

    fun checkCredentials(listener: Listener) {
        listener.credentialsInvalid()
        // TODO check real credentials.
    }

}