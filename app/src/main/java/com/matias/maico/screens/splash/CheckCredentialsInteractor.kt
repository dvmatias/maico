package com.matias.maico.screens.splash

class CheckCredentialsInteractor {

    interface Listener {
        fun credentialsValid()
        fun credentialsInvalid()
    }

    fun checkCredentials(listener: Listener) {
        // TODO Check for valid credentials.
    }

}