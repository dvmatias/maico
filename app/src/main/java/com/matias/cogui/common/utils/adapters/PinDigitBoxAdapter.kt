package com.matias.cogui.common.utils.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matias.cogui.R

class PinDigitBoxAdapter(var digitsCount: Int) : RecyclerView.Adapter<PinDigitBoxAdapter.PinDigitHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinDigitHolder {
		val itemView = LayoutInflater.from(parent.context)
			.inflate(R.layout.item_pin_digit_box, parent, false)
		return PinDigitBoxAdapter.PinDigitHolder(itemView)
	}

	override fun getItemCount(): Int {
		return digitsCount
	}

	override fun onBindViewHolder(holder: PinDigitHolder, position: Int) {
		// Set a tag to keep track of item inside [PinDigitBoxItemDecoration] decorator.
		holder.itemView.tag = "$position"
	}

	/**
	 * Item view holder.
	 */
	class PinDigitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	}

}