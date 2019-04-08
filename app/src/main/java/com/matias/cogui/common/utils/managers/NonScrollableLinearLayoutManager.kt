package com.matias.cogui.common.utils.managers

import android.content.Context
import android.support.v7.widget.LinearLayoutManager

/**
 * This class is intended to serve as a Linear Layout Manager for recycler views.
 * The capability that offers is to enable/disable the vertical and horizontal scroll
 * ability.
 */
class NonScrollableLinearLayoutManager(context: Context, orientation: Int, reverseLayout: Boolean) :
	LinearLayoutManager(context, orientation, reverseLayout) {

	private var isScrollEnabled = true

	/**
	 * Set the scroll enable/disable by set the flag variables in tru/false.
	 */
	fun setScrollEnabled(flag: Boolean) {
		this.isScrollEnabled = flag
	}

	override fun canScrollVertically(): Boolean {
		return isScrollEnabled && super.canScrollVertically()
	}

	override fun canScrollHorizontally(): Boolean {
		return isScrollEnabled && super.canScrollHorizontally()
	}

}