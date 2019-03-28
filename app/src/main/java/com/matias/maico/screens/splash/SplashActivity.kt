package com.matias.maico.screens.splash

import android.os.Bundle
import android.util.Log
import android.view.View
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity
import javax.inject.Inject

import kotlinx.android.synthetic.main.activity_splash.*

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

        setup()
    }

    private fun setup() {
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
        Log.d(TAG, "MABEL - Go to ValidateCredentialsScreen.")
    }

    override fun showLoading(show: Boolean) {
        pb.visibility = if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun showNeedPermissionDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoConnectionErrorDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
