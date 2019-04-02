package com.matias.maico.screens.choosecountry

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.matias.maico.R
import com.matias.maico.common.model.objects.Country
import com.matias.maico.common.utils.ImageLoader
import com.matias.maico.screens.choosecountry.CountryListAdapter.CountryViewHolder
import kotlinx.android.synthetic.main.item_country.view.*

class CountryListAdapter(listener: ClickListener, var imageLoader: ImageLoader) :
	RecyclerView.Adapter<CountryViewHolder>() {

	private var countryList: List<Country>? = null

	private var clickListener: ClickListener = listener

	interface ClickListener {
		fun onItemClick(itemCountry: Country?)
	}

	fun setData(countryList: List<Country>) {
		this.countryList = countryList
		notifyDataSetChanged()
	}

	/**
	 * View Holder.
	 */
	class CountryViewHolder(itemView: View) :
		RecyclerView.ViewHolder(itemView) {
		var ivFlag: ImageView = itemView.iv_flag
		var tvCode: TextView = itemView.tv_code
		var tvName: TextView = itemView.tv_name
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
		val itemView = LayoutInflater.from(parent.context)
			.inflate(R.layout.item_country, parent, false)
		return CountryViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
		val itemCountry = countryList!![position]
		imageLoader.loadImage(holder.ivFlag, itemCountry.url)
		holder.tvName.tv_name.text = itemCountry.name
		holder.tvCode.tv_code.text = itemCountry.code
		holder.itemView.setOnClickListener {
			clickListener.onItemClick(itemCountry)
		}
	}

	override fun getItemCount(): Int = if (countryList != null) countryList!!.size else 0

}