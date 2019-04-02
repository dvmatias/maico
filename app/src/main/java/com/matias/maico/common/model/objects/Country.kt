package com.matias.maico.common.model.objects

class Country(
		var name: String,
		var initials: String,
		var url: String,
		code: Int) {

	var code: String = code.toString()
		get() = "+ $field"


}