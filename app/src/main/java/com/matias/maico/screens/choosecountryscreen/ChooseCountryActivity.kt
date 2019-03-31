package com.matias.maico.screens.choosecountryscreen

import android.os.Bundle
import android.view.MenuItem
import com.matias.maico.R
import com.matias.maico.common.mvp.BaseActivity

class ChooseCountryActivity : BaseActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_choose_country)

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

}
