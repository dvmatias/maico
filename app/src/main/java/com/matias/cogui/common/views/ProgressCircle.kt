package com.matias.cogui.common.views

import android.content.Context
import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.ProgressBar
import com.matias.cogui.R


class ProgressCircle : ProgressBar {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context)
    }

    private fun init(context: Context) {
        val drawable = indeterminateDrawable
        drawable?.setColorFilter(
                ContextCompat.getColor(context, R.color.color_progress), PorterDuff.Mode.SRC_IN)
    }

}