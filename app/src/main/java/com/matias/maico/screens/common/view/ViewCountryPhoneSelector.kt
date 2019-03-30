package com.matias.maico.screens.common.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.matias.maico.R
import kotlinx.android.synthetic.main.view_country_phone_selector.view.*

class ViewCountryPhoneSelector(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), View.OnClickListener, TextWatcher {

    private lateinit var listener: Listener

    /**
     * [TextWatcher] interface implementation.
     */

    override fun afterTextChanged(s: Editable?) { }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (!s.isNullOrBlank() && s.isNotEmpty()) listener.onPhoneNotEmpty() else listener.onPhoneEmpty()
    }

    /**
     * Catch click actions.
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            btn_country.id -> listener.onCountryClick()
        }
    }

    /**
     * Interface to be implemented by calling Activity.
     */
    interface Listener {
        fun onCountryClick()
        fun onPhoneEmpty()
        fun onPhoneNotEmpty()
    }

    /**
     * Init view.
     */
    init {
        inflate(context, R.layout.view_country_phone_selector, this)

        btn_country.setOnClickListener(this)
        et_phone.addTextChangedListener(this)

        setClickListener(context)
    }

    /**
     * Set click listener.
     */
    private fun setClickListener(context: Context) {
        if (context is Listener)
            this.listener = context
        else
            throw IllegalAccessException("Calling Activity must implement ViewCountryPhoneSelector.Listener interface.")
    }

}