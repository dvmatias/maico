package com.matias.cogui.common.utils

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class PinDigitBoxItemDecoration(private val mSpaceHeight: Int) :
	RecyclerView.ItemDecoration() {

	override fun getItemOffsets(
		outRect: Rect, view: View, parent: RecyclerView,
		state: RecyclerView.State
	) {
		if (view.tag.toString() != "0") {
			outRect.left = mSpaceHeight
		}
	}
}