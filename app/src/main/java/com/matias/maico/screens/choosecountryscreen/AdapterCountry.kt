package com.matias.maico.screens.choosecountryscreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.matias.maico.R
import com.matias.maico.screens.choosecountryscreen.AdapterCountry.CountryViewHolder
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry(private val data: List<Country>) : RecyclerView.Adapter<CountryViewHolder>() {

	/**
	 * View Holder.
	 */
	class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

		var ivFlag: ImageView =  itemView.iv_flag
		var tvCode: TextView =  itemView.tv_code
		var tvName: TextView =  itemView.tv_name

		init {
			itemView.setOnClickListener(this)
		}

		override fun onClick(v: View?) {
			TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
		val itemView = LayoutInflater.from(parent.context)
				.inflate(R.layout.item_country, parent, false)
		return CountryViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
		val country = data[position]
		// TODO manage image. Glide.
		holder.tvName.tv_name.text = country.name
		holder.tvCode.tv_code.text = country.code
	}

	override fun getItemCount(): Int {
		return data.size
	}

}