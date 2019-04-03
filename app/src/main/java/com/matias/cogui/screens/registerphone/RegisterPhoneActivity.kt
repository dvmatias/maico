package com.matias.cogui.screens.registerphone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.matias.cogui.R
import com.matias.cogui.common.Constants.Companion.EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY
import com.matias.cogui.common.Constants.Companion.REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY
import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BaseActivity
import com.matias.cogui.common.utils.ImageLoader
import com.matias.cogui.common.views.ViewAgreement
import com.matias.cogui.common.views.ViewCountryPhoneSelector
import com.matias.cogui.screens.choosecountry.ChooseCountryActivity
import kotlinx.android.synthetic.main.activity_validate_credentials.*
import javax.inject.Inject

class RegisterPhoneActivity : BaseActivity(),
	RegisterPhoneContract.View,
	ViewCountryPhoneSelector.Listener,
	ViewAgreement.Listener {

	@Inject lateinit var presenter: RegisterPhonePresenter
	@Inject lateinit var gson: Gson
	@Inject lateinit var imageLoader: ImageLoader

	private var isAgreementViewVisible: Boolean = false
	private lateinit var selectedCountry: Country

	companion object {
		// Class tag.
		@Suppress("unused")
		private val TAG = RegisterPhoneActivity::class.java.simpleName
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_validate_credentials)
		getPresentationComponent().inject(this)
		// Construct a default country object.
		setSelectedCountry(Country())
	}

	override fun onBackPressed() {
		super.onBackPressed()
		finish()
	}

	override fun onResume() {
		super.onResume()
		showSelectedCountry()
	}

	/*
     * MVP - [RegisterPhoneContract.View] interface implementation.
     */

	override fun goToChooseCountryScreen() {
		val intent = Intent(this, ChooseCountryActivity::class.java)
		intent.putExtra(EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY, gson.toJson(selectedCountry))
		startActivityForResult(intent, REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY)
	}

	override fun goToHomeScreen() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun setSelectedCountry(country: Country) {
		selectedCountry = country
	}

	override fun showNoConnectionErrorDialog() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun showGetStartButton(show: Boolean) {
		btn_get_started.visibility = if (show) View.VISIBLE else View.GONE
	}

	override fun showSelectedCountry() {
		v_country_phone_selector.setCountry(this.selectedCountry, imageLoader)
	}

	override fun showTermsAndConditions(show: Boolean) {
		if (isAgreementViewVisible == show) return
		isAgreementViewVisible = show
		if (show) agreement_view.setChecked(!show)
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
		if (requestCode == REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY) {
			selectedCountry = when(resultCode) {
				Activity.RESULT_OK -> {
					gson.fromJson(
						data?.getStringExtra(EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY),
						Country::class.java
					)
				}
				Activity.RESULT_CANCELED -> this.selectedCountry
				else -> Country()
			}
			setSelectedCountry(selectedCountry)
			showSelectedCountry()
		}
	}
}