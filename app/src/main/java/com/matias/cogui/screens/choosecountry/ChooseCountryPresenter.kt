package com.matias.cogui.screens.choosecountry

import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.model.schemas.CountrySchema
import com.matias.cogui.common.mvp.BasePresenterImpl

class ChooseCountryPresenter(
	v: ChooseCountryContract.View,
	var fetchCountryListInteractor: FetchCountryListInteractor
) : BasePresenterImpl<ChooseCountryContract.View>(),
	ChooseCountryContract.Presenter,
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
			Country(it.name, it.code, it.url)
		}
		view?.setData(countryList)
		view?.showLoading(false)
	}

	override fun onFailure() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onEmptyResult() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}