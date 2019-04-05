package com.matias.cogui.common.views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.matias.cogui.R
import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.utils.ImageLoader
import javax.inject.Inject
import kotlinx.android.synthetic.main.view_country_phone_selector.view.*

class ViewCountryPhoneSelector(context: Context, attrs: AttributeSet) :
		LinearLayout(context, attrs), View.OnClickListener, TextWatcher {

	@Inject
	lateinit var imageLoader: ImageLoader

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

	fun setCountry(selectedCountry: Country, imageLoader: ImageLoader) {
		imageLoader.loadImage(iv_flag, selectedCountry.url)
		tv_code.text = selectedCountry.code
	}

	private fun showError(errorMessage: String) {
		tv_error.text = errorMessage
		tv_error.visibility = View.VISIBLE
	}

	private fun hideError() {
		tv_error.visibility = View.INVISIBLE
	}

}