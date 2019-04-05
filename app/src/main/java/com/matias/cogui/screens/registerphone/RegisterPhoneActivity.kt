package com.matias.cogui.screens.registerphone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.matias.cogui.R
import com.matias.cogui.common.Constants.Companion.EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY
import com.matias.cogui.common.Constants.Companion.REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY
import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BaseActivity
import com.matias.cogui.common.utils.managers.DialogsManager
import com.matias.cogui.common.utils.managers.PhoneManager
import com.matias.cogui.common.views.ViewAgreement
import com.matias.cogui.common.views.ViewCountryPhoneSelector
import com.matias.cogui.screens.choosecountry.ChooseCountryActivity
import kotlinx.android.synthetic.main.activity_validate_credentials.*
import javax.inject.Inject

class RegisterPhoneActivity : BaseActivity(),
	RegisterPhoneContract.View,
	EnterPhoneFragment.Listener,
	ViewCountryPhoneSelector.Listener,
	ViewAgreement.Listener {

	@Inject
	lateinit var presenter: RegisterPhonePresenter
	@Inject
	lateinit var gson: Gson
	@Inject
	lateinit var phoneManager: PhoneManager
	@Inject
	lateinit var dialogsManager: DialogsManager

	private lateinit var selectedCountry: Country
	private val enterPhoneFragment = EnterPhoneFragment.newInstance(null)

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
		goToEnterPhoneScreen()
	}

	override fun onBackPressed() {
		super.onBackPressed()
		finish()
	}

	override fun onResume() {
		super.onResume()
		showSelectedCountry()
	}

	/**
	 * MVP - [RegisterPhoneContract.View] interface implementation.
	 */

	override fun goToEnterPhoneScreen() {
		supportFragmentManager
			.beginTransaction()
			.add(fl_container.id, enterPhoneFragment, enterPhoneFragment.tag)
			.commit()
	}

	override fun goToValidatePhoneScreen() {
		Toast.makeText(this, "Go to Validate Phone Screen", Toast.LENGTH_SHORT).show()
	}

	override fun setSelectedCountry(country: Country) {
		this.selectedCountry = country
	}

	override fun showNoConnectionErrorDialog() {
		Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
	}

	override fun showSelectedCountry() {
		enterPhoneFragment.showSelectedCountry(this.selectedCountry)
	}

	override fun showWrongCountryDialog() {
//		dialogsManager.showRetainedDialogWithId(DialogFragment()) TODO
		Toast.makeText(this, "Wrong Country", Toast.LENGTH_SHORT).show()
	}

	override fun showWrongNumberDialog() {
		Toast.makeText(this, "Wrong Number", Toast.LENGTH_SHORT).show()
	}

	/**
	 * [EnterPhoneFragment.Listener] interface implementation.
	 */

	override fun goToChooseCountryScreen() {
		val intent = Intent(this, ChooseCountryActivity::class.java)
		intent.putExtra(EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY, gson.toJson(selectedCountry))
		startActivityForResult(intent, REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY)
	}

	override fun onGetStartedClick(phoneNumber: String) {
		presenter.validatePhoneNumber(selectedCountry.nameCode, phoneNumber)
	}

	/**
	 * [ViewCountryPhoneSelector.Listener] interface implementation.
	 */

	override fun onCountryClick() {
		goToChooseCountryScreen()
	}

	override fun onPhoneEmpty() {
		enterPhoneFragment.showTermsAndConditions(false)
		enterPhoneFragment.showGetStartButton(false)
	}

	override fun onPhoneNotEmpty() {
		enterPhoneFragment.showTermsAndConditions(true)
	}

	/**
	 * [ViewAgreement.Listener] interface implementation.
	 */

	override fun onAgreementAccepted() {
		enterPhoneFragment.showGetStartButton(true)
	}

	override fun onAgreementRejected() {
		enterPhoneFragment.showGetStartButton(false)
	}

	/**
	 * On Activity Result-
	 */

	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == REQUEST_CODE_CHOOSE_COUNTRY_ACTIVITY) {
			selectedCountry = when (resultCode) {
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