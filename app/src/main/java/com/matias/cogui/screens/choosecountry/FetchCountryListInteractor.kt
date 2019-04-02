package com.matias.cogui.screens.choosecountry

import android.os.Handler
import android.util.Log
import com.matias.cogui.common.model.schemas.CountrySchema

class FetchCountryListInteractor {

	interface Listener {
		fun onSuccess(countrySchema: CountrySchema)
		fun onFailure()
		fun onEmptyResult()
	}

	fun fetch(listener: Listener) {
		Log.d(FetchCountryListInteractor::class.java.simpleName, "*** MABEL fetch() get country list.")
		Handler().postDelayed({
			listener.onSuccess(getMockCountryList())
		},1000)
	}

	private fun getMockCountryList(): CountrySchema {
		val countryList = mutableListOf<CountrySchema.Country>()
		countryList.add(CountrySchema.Country("Afghanistan", "AF", "https://imgur.com/oNSpefC.jpg", 93))
		countryList.add(CountrySchema.Country("Albania", "AL", "https://imgur.com/c1fvRiX.jpg", 355))
		countryList.add(CountrySchema.Country("Algeria", "DZ", "https://imgur.com/T1oRQkx.jpg", 213))
		countryList.add(CountrySchema.Country("Andorra", "AD", "https://imgur.com/TIFzixn.jpg", 376))
		countryList.add(CountrySchema.Country("Angola", "AO", "https://imgur.com/WnbW5Rm.jpg", 244))
		countryList.add(CountrySchema.Country("Argentina", "AR", "https://imgur.com/yb0naH9.jpg", 54))
		return CountrySchema(countryList)
	}
}