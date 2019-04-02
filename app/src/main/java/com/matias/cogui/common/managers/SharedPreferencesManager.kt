package com.matias.cogui.common.managers

import android.content.Context
import android.content.SharedPreferences


class SharedPreferencesManager(private var context: Context) {

    companion object {
        const val PREFS_NAME = "credentials"
        const val KEY_PHONE_NUMBER = "phone"
    }

    private var sharedPrefs: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        sharedPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor = sharedPrefs.edit()
    }

}