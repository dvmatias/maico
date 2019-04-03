package com.matias.cogui.screens.choosecountry

import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BasePresenter
import com.matias.cogui.common.mvp.BaseView

interface ChooseCountryContract {

	interface View : BaseView {
		fun finishWithResult(selectedCountry: Country?)
		fun setData(countryList: List<Country>)
		fun showEmptyState()
		fun showLoading(show: Boolean)
		fun showRetryState()
	}

	interface Presenter : BasePresenter<View> {
		fun fetchCountryList()
	}

}