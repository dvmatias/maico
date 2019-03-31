package com.matias.maico.screens.common

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.matias.maico.R
import kotlinx.android.synthetic.main.view_agreements.view.*

class ViewAgreement(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs), View.OnClickListener {

    private lateinit var listener: Listener

    override fun onClick(v: View?) {
        when (v?.id) {
            iv_checkbox.id -> setChecked(!iv_checkbox.isSelected)
        }
    }

    interface Listener {
        fun onAgreementAccepted()
        fun onAgreementRejected()
    }

    init {
        inflate(context, R.layout.view_agreements, this)

        iv_checkbox.setOnClickListener(this)

        setClickListener()
    }

    private fun setClickListener() {
        if (context is ViewAgreement.Listener)
            this.listener = this.context as ViewAgreement.Listener
        else
            throw IllegalAccessException("Calling Activity must implement ViewAgreement.Listener interface.")
    }

    private fun setCheckStatus(isChecked: Boolean) {
        if (isChecked) {
            setCheckedImage()
            listener.onAgreementAccepted()
        } else {
            setUncheckedImage()
            listener.onAgreementRejected()
        }
    }

    private fun setCheckedImage() {
        iv_checkbox.setImageDrawable(context.getDrawable(R.drawable.ic_check_circle_checked))
    }

    private fun setUncheckedImage() {
        iv_checkbox.setImageDrawable(context.getDrawable(R.drawable.ic_check_circle_unchecked))
    }

	fun setChecked(isChecked: Boolean) {
		iv_checkbox.isSelected = isChecked
		setCheckStatus(isChecked)
	}

}