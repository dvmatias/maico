package com.matias.maico.screens.choosecountryscreen

import com.matias.maico.common.model.objects.Country
import com.matias.maico.common.model.schemas.CountrySchema
import com.matias.maico.common.mvp.BasePresenterImpl

class ChooseCountryPresenter(
	v: ChooseCountryContract.View,
	var fetchCountryListInteractor: FetchCountryListInteractor
) : BasePresenterImpl<ChooseCountryContract.View>(), ChooseCountryContract.Presenter,
	FetchCountryListInteractor.Listener {

	init {
		bind(v)
	}

	override fun fetchCountryList() {
		view?.showLoading(true)
		fetchCountryListInteractor.fetch(this)
	}

	override fun onSuccess(countrySchema: CountrySchema) {
		val countryList = countrySchema.countryList.map {
			Country(it.name, it.initials, it.url, it.code)
		}

		view?.setCountryList(countryList)
	}

	override fun onFailure() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onEmptyResult() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}