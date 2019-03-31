package com.matias.maico.screens.common.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.matias.maico.R
import kotlinx.android.synthetic.main.view_country_phone_selector.view.*

class ViewCountryPhoneSelector(context: Context, attrs: AttributeSet) :
		LinearLayout(context, attrs), View.OnClickListener, TextWatcher {

    private lateinit var listener: Listener

    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (!s.isNullOrBlank() && s.isNotEmpty()) listener.onPhoneNotEmpty() else listener.onPhoneEmpty()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btn_country.id -> listener.onCountryClick()
        }
    }

    interface Listener {
        fun onCountryClick()
        fun onPhoneEmpty()
        fun onPhoneNotEmpty()
    }

    init {
        inflate(context, R.layout.view_country_phone_selector, this)

        btn_country.setOnClickListener(this)
        et_phone.addTextChangedListener(this)
	    hideError()

        setClickListener()
    }

    private fun setClickListener() {
        if (context is Listener)
            this.listener = this.context as Listener
        else
            throw IllegalAccessException("Calling Activity must implement ViewCountryPhoneSelector.Listener interface.")
    }

	private fun showError(errorMessage: String) {
		tv_error.text = errorMessage
		tv_error.visibility = View.VISIBLE
	}

	private fun hideError() {
		tv_error.visibility = View.INVISIBLE
	}

}