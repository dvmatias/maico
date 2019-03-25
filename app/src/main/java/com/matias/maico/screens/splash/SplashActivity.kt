package com.matias.maico.screens.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.matias.maico.R

class SplashActivity : AppCompatActivity(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    /*
     * MVP - Contract view methods implementations.
     */

    override fun showLoading(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun askUserPermissionFineLocation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNeedPermissionDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkNetworkStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoConnectionError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun gotToHomeScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
