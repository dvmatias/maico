package com.matias.maico.screens.choosecountryscreen

import android.os.Handler
import android.util.Log
import com.matias.maico.common.model.schemas.CountrySchema

class FetchCountryListInteractor {

	interface Listener {
		fun onSuccess(countryList: CountrySchema)
		fun onFailure()
		fun onEmptyResult()
	}

	fun fetch(listener: Listener) {
		Log.d(FetchCountryListInteractor::class.java.simpleName, "*** MABEL fetch() get country list.")
		Handler().postDelayed(Runnable {
			listener.onSuccess(getMockCountryList())
		},1000)
	}

	private fun getMockCountryList(): CountrySchema {
		val countryList = mutableListOf<CountrySchema.Country>()
		countryList.add(CountrySchema.Country("Afghanistan", "AF", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "93"))
		countryList.add(CountrySchema.Country("Albania", "AL", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "355"))
		countryList.add(CountrySchema.Country("Algeria", "DZ", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "213"))
		countryList.add(CountrySchema.Country("Andorra", "AD", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "376"))
		countryList.add(CountrySchema.Country("Angola", "AO", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "244"))
		countryList.add(CountrySchema.Country("Antartica", "AQ", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "672"))
		countryList.add(CountrySchema.Country("Argentina", "AR", "https://www.wichitapride.org/wp-content/uploads/2018/05/3x5-Pride-Flag-for-Sale.jpg", "54"))

		return CountrySchema(countryList)
	}
}