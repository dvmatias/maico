package com.matias.maico.screens.common

import android.content.Context
import android.util.AttributeSet
import android.view.View.inflate
import android.widget.LinearLayout
import com.matias.maico.R

class ViewAgreement(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    /**
     * Init view.
     */
    init {
        inflate(context, R.layout.view_agreements, this)
    }


}