package com.matias.maico.screens.splash

import com.matias.maico.common.managers.SharedPreferencesManager

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