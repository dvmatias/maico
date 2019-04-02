package com.matias.maico.screens.validatecredentials

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.matias.maico.R
import com.matias.maico.common.Constants
import com.matias.maico.common.mvp.BaseActivity
import com.matias.maico.screens.choosecountryscreen.ChooseCountryActivity
import com.matias.maico.screens.common.ViewAgreement
import com.matias.maico.screens.common.view.ViewCountryPhoneSelector
import kotlinx.android.synthetic.main.activity_validate_credentials.*
import javax.inject.Inject

class ValidateCredentialsActivity : BaseActivity(),
		ValidateCredentialsContract.View,
		ViewCountryPhoneSelector.Listener,
		ViewAgreement.Listener {

    @Inject lateinit var presenter: ValidateCredentialsPresenter

	private var isAgreementViewVisible: Boolean = false

    companion object {
        // Class tag.
        private val TAG = ValidateCredentialsActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validate_credentials)
	    getPresentationComponent().inject(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    /*
     * MVP - [ValidateCredentialsContract.View] interface implementation.
     */

    override fun goToChooseCountryScreen() {
        val intent = Intent(this, ChooseCountryActivity::class.java)
        startActivityForResult(intent, Constants.REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY)
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
	    btn_get_started.visibility = if(show) View.VISIBLE else View.GONE
    }

	override fun showTermsAndConditions(show: Boolean) {
		if (isAgreementViewVisible == show) return
		isAgreementViewVisible = show
		if (show)
			agreement_view.setChecked(!show)
		agreement_view.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun showWrongCountryInlineError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showWrongNumberInlineError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*
     * [ViewCountryPhoneSelector.Listener] interface implementation.
     */

    override fun onCountryClick() {
        goToChooseCountryScreen()
    }

    override fun onPhoneEmpty() {
        showTermsAndConditions(false)
	    showGetStartButton(false)
    }
    override fun onPhoneNotEmpty() {
        showTermsAndConditions(true)
    }

	/*
	 * [ViewAgreement.Listener] interface implementation.
	 */

	override fun onAgreementAccepted() {
		showGetStartButton(true)
	}

	override fun onAgreementRejected() {
		showGetStartButton(false)
	}

    /*
     * On Activity Result-
     */

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}