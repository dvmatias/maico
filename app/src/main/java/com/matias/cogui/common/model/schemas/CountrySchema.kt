package com.matias.cogui.common.model.schemas

class CountrySchema(
	var countryList: List<Country>
) {
	data class Country(
		var name: String,
		var code: String,
		var url: String
	)
}