package com.matias.cogui.common.utils

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager

class UiHelper(var activity: Activity) {

	fun hideKeyboard() {
		try {
			val inputMethodManager = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
			inputMethodManager.hideSoftInputFromWindow(activity.currentFocus?.windowToken, 0)
		} catch (e: Exception) {
			// TODO: handle exception
		}
	}

}