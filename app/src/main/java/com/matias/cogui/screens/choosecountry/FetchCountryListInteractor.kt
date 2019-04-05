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
		},750)
	}

	private fun getMockCountryList(): CountrySchema {
		val countryList = mutableListOf<CountrySchema.Country>()
		countryList.add(CountrySchema.Country("Afghanistan", "AF", "https://imgur.com/oNSpefC.jpg"))
		countryList.add(CountrySchema.Country("Albania", "AL", "https://imgur.com/c1fvRiX.jpg"))
		countryList.add(CountrySchema.Country("Algeria", "DZ", "https://imgur.com/T1oRQkx.jpg"))
		countryList.add(CountrySchema.Country("Andorra", "AD", "https://imgur.com/TIFzixn.jpg"))
		countryList.add(CountrySchema.Country("Angola", "AO", "https://imgur.com/WnbW5Rm.jpg"))
		countryList.add(CountrySchema.Country("Argentina", "AR", "https://imgur.com/yb0naH9.jpg"))
		return CountrySchema(countryList)
	}
}