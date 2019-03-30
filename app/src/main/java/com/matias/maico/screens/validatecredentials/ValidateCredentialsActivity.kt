package com.matias.maico.screens.validatecredentials

import android.os.Bundle
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity
import com.matias.maico.screens.common.view.ViewCountryPhoneSelector
import javax.inject.Inject

class ValidateCredentialsActivity : BaseActivity(), ValidateCredentialsContract.View, ViewCountryPhoneSelector.ClickListener {

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
     * MVP - [ValidateCredentialsContract.View] interface implementation.
     */

    override fun goToChooseCountryScreen() {
        // TODO launch ChooseCountryActivity.
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

    /*
     * [ViewCountryPhoneSelector.ClickListener] interface implementation.
     */

    override fun onCountryClick() {
        goToChooseCountryScreen()
    }
}
