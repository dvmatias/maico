package com.matias.maico.common.model.schemas

class CountrySchema(
	var countryList: List<Country>
) {
	data class Country(
		var name: String,
		var initials: String,
		var url: String,
		var code: Int
	)
}