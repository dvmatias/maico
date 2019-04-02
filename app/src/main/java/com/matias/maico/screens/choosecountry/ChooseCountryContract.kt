package com.matias.maico.screens.choosecountry

import com.matias.maico.common.model.objects.Country
import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface ChooseCountryContract {

	interface View : BaseView {
		fun showLoading(show: Boolean)
		fun setCountryList(countryList: List<Country>)
		fun showEmptyState()
		fun showRetryState()
	}

	interface Presenter : BasePresenter<View> {
		fun fetchCountryList()
	}

}