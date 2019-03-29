package com.matias.maico.screens.validatecredentials

import android.os.Bundle
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity
import javax.inject.Inject

class ValidateCredentialsActivity : BaseActivity(), ValidateCredentialsContract.View {

    @Inject lateinit var presenter: ValidateCredentialsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_credentials)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    /*
     * MVP - Contract view methods implementations.
     */

    override fun animateUserPhoneView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToChooseCountryScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToHomeScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setCountry(countryName: String, countryFlagUrl: String, countryPrefix: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoConnectionErrorDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showGetStartButton(show: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showTermsAndConditions() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWrongCountryInlineError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWrongNumberInlineError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
