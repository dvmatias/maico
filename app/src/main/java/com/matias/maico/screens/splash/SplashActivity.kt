package com.matias.maico.screens.splash

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity
import com.matias.maico.screens.validatecredentials.ValidateCredentialsActivity
import kotlinx.android.synthetic.main.activity_splash.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject lateinit var presenter: SplashPresenter

    companion object {
        // Class tag.
        private val TAG = SplashActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        getPresentationComponent().inject(this)


    }

    override fun onResume() {
        super.onResume()
        presenter.checkInternetConnectionStatus()
    }

    /*
     * MVP - Contract view methods implementations.
     */

    override fun checkInternetConnectionStatus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun checkCredentials() {
        presenter.checkCredentials()
    }

    override fun askUserPermissionFineLocation() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun gotToHomeScreen() {
        Log.d(TAG, "MABEL - Go to HomeScreen.")
    }

    override fun goToValidateCredentialsScreen() {
        val intent = Intent(this, ValidateCredentialsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun showNeedPermissionDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoConnectionErrorDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}