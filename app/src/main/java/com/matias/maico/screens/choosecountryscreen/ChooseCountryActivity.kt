package com.matias.maico.screens.choosecountryscreen

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity
import javax.inject.Inject

class ChooseCountryActivity : BaseActivity(), ChooseCountryContract.View {

	@Inject lateinit var presenter: ChooseCountryPresenter

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
	}

	override fun setCountryList() {
		Log.d(TAG, "*** MABEL setCountryList()")
	}

	override fun showEmptyState() {
		Log.d(TAG, "*** MABEL showEmptyState()")
	}

	override fun showRetryState() {
		Log.d(TAG, "*** MABEL showRetryState()")
	}
}
