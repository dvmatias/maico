package com.matias.maico.screens.choosecountryscreen

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.MenuItem
import com.matias.maico.R
import com.matias.maico.common.model.objects.Country
import com.matias.maico.common.mvp.BaseActivity
import kotlinx.android.synthetic.main.activity_choose_country.*
import javax.inject.Inject

class ChooseCountryActivity : BaseActivity(), ChooseCountryContract.View, CountryListAdapter.ClickListener {

	@Inject lateinit var presenter: ChooseCountryPresenter
	@Inject lateinit var adapter: CountryListAdapter

	companion object {
		// Class tag.
		private val TAG = ChooseCountryActivity::class.java.simpleName
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_choose_country)
		getPresentationComponent().inject(this)

		actionBar?.setDisplayHomeAsUpEnabled(true)
		actionBar?.title = "Choose Country"

		rv_country.layoutManager = LinearLayoutManager(this)
		rv_country.adapter = adapter
	}

	override fun onOptionsItemSelected(item: MenuItem?): Boolean {
		return when(item?.itemId) {
			R.id.homeAsUp -> {
				finish()
				true
			}
			else -> super.onOptionsItemSelected(item)
		}
	}

	override fun onSupportNavigateUp(): Boolean {
		finish()
		return true
	}

	override fun onResume() {
		super.onResume()
		presenter.fetchCountryList()
	}

	/*
	 * MVP - [ChooseCountryContract.View] interface implementation.
	 */

	override fun showLoading(show: Boolean) {
		Log.d(TAG, "*** MABEL showLoading() $show")
		// TODO
	}

	override fun setCountryList(countryList: List<Country>) {
		adapter.setData(countryList)
	}

	override fun showEmptyState() {
		Log.d(TAG, "*** MABEL showEmptyState()")
		// TODO
	}

	override fun showRetryState() {
		Log.d(TAG, "*** MABEL showRetryState()")
		// TODO
	}

	/*
	 * [CountryListAdapter.ClickListener] interface implementation.
	 */

	override fun onItemClick(itemCountry: Country?) {
		Log.d(TAG, "*** MABEL onItemClick() $itemCountry")
		// TODO
	}
}
