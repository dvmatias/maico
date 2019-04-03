package com.matias.cogui.screens.choosecountry

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson
import com.matias.cogui.R
import com.matias.cogui.common.Constants.Companion.EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY
import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_choose_country.*
import javax.inject.Inject

class ChooseCountryActivity : BaseActivity(),
	ChooseCountryContract.View,
	CountryListAdapter.ClickListener {

	@Inject lateinit var presenter: ChooseCountryPresenter
	@Inject lateinit var adapter: CountryListAdapter

	private lateinit var selectedCountry: Country

	companion object {
		// Class tag.
		private val TAG = ChooseCountryActivity::class.java.simpleName
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_choose_country)
		getPresentationComponent().inject(this)

		setupActionBar()
		setupRecyclerView()
		getExtras()
	}

	private fun setupActionBar() {
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		supportActionBar?.title = "Choose Country"
	}

	private fun setupRecyclerView() {
		rv_country.layoutManager = LinearLayoutManager(this)
		rv_country.adapter = adapter
	}

	private fun getExtras() {
		selectedCountry = Gson().fromJson(
			intent.getStringExtra(EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY),
			Country::class.java
		)
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		return when (item?.itemId) {
			R.id.homeAsUp -> {
				finish()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onSupportNavigateUp(): Boolean {
		finishWithResult(null)
		return true
	}

	override fun onResume() {
		super.onResume()
		presenter.fetchCountryList()
	}

	/*
	 * MVP - [ChooseCountryContract.View] interface implementation.
	 */

	override fun finishWithResult(selectedCountry: Country?) {
		if (null != selectedCountry) {
			val intent = Intent()
			intent.putExtra(
				EXTRA_KEY_SELECTED_COUNTRY_COUNTRY_ACTIVITY,
				Gson().toJson(selectedCountry)
			)
			setResult(Activity.RESULT_OK, intent)
		} else {
			setResult(Activity.RESULT_CANCELED)
		}
		finish()
	}

	override fun setData(countryList: List<Country>) {
		adapter.setData(countryList)
	}

	override fun showEmptyState() {
		Log.d(TAG, "*** MABEL showEmptyState()")
		// TODO
	}

	override fun showLoading(show: Boolean) {
		if (show) {
			rv_country.visibility = View.GONE
			progress.visibility = View.VISIBLE
		} else {
			progress.visibility = View.GONE
			rv_country.visibility = View.VISIBLE
		}
	}

	override fun showRetryState() {
		Log.d(TAG, "*** MABEL showRetryState()")
		// TODO
	}

	/*
	 * [CountryListAdapter.ClickListener] interface implementation.
	 */

	override fun onItemClick(itemCountry: Country) {
		selectedCountry = itemCountry
		finishWithResult(itemCountry)
	}
}
