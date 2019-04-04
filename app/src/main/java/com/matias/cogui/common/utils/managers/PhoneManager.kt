package com.matias.cogui.common.utils.managers

import com.google.i18n.phonenumbers.PhoneNumberUtil

class PhoneManager(var phoneNumberUtil: PhoneNumberUtil) {

    fun getFormattedCountryCodeForRegion(nameCode: String): CharSequence? {
        val numericCode = phoneNumberUtil.getCountryCodeForRegion(nameCode)
        return "+$numericCode"
    }
}