package com.matias.cogui.common.model.objects

class Country(
		var name: String = "Default",
		var initials: String = "XX",
		var url: String = "https://imgur.com/exxWvOK.jpg",
		code: Int = 1) {

	var code: String = code.toString()
		get() = "+ $field"


}