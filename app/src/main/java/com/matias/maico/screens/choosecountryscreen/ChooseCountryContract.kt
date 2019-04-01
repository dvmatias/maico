package com.matias.maico.screens.choosecountryscreen

import com.matias.maico.common.mvp.BasePresenter
import com.matias.maico.common.mvp.BaseView

interface ChooseCountryContract {

	interface View : BaseView {
		fun showLoading(show: Boolean)
		fun setCountryList()
		fun showEmptyState()
		fun showRetryState()
	}

	interface Presenter : BasePresenter<View> {
		fun fetchCountryList()
	}

}