package com.matias.maico.screens.common.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.matias.maico.R
import kotlinx.android.synthetic.main.view_country_phone_selector.view.*

class ViewCountryPhoneSelector(context: Context, attrs: AttributeSet): LinearLayout(context, attrs) {

    init {
        inflate(context, R.layout.view_country_phone_selector, this)
    }

}