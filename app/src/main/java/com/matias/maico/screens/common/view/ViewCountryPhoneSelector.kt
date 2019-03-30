package com.matias.maico.screens.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.matias.maico.R
import kotlinx.android.synthetic.main.view_country_phone_selector.view.*

class ViewCountryPhoneSelector(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), View.OnClickListener {

    private lateinit var clickListener: ClickListener

    interface ClickListener {
        fun onCountryClick()
    }

    init {
        inflate(context, R.layout.view_country_phone_selector, this)

        btn_country.setOnClickListener(this)

        setClickListener(context)
    }

    private fun setClickListener(context: Context) {
        if (context is ClickListener)
            this.clickListener = context
        else
            throw IllegalAccessException("Calling Activity/Fragment must implement ViewCountryPhoneSelector.ClickListener interface")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btn_country.id -> clickListener.onCountryClick()
        }
    }

}