package com.matias.cogui.common.views

import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.matias.cogui.R
import kotlinx.android.synthetic.main.view_pin_validator.view.*

/**
 * TODO: document your custom view class.
 */
class PinValidatorView : LinearLayout {

	private var _numberOfDigits: Int = context.resources.getInteger(R.integer.four)

	/**
	 * In the example view, this dimension is the font size.
	 */
	var numberOfDigits: Int
		get() = _numberOfDigits
		set(value) {
			_numberOfDigits = value
//			invalidateTextPaintAndMeasurements()
			// TODO
		}

	constructor(context: Context) : super(context) {
		init(null, 0)
	}

	constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
		init(attrs, 0)
	}

	constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
		context,
		attrs,
		defStyle
	) {
		init(attrs, defStyle)
	}

	private fun init(attrs: AttributeSet?, defStyle: Int) {
		// inflate layout
		inflate(context, R.layout.view_pin_validator, this)
		// Load attributes
		val a = context.obtainStyledAttributes(
			attrs, R.styleable.PinValidatorView, defStyle, 0
		)

		// Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
		// values that should fall on pixel boundaries.
		_numberOfDigits = a.getInt(
			R.styleable.PinValidatorView_numberOfDigits,
			numberOfDigits
		)

		a.recycle()

		// Update TextPaint and text measurements from attributes
		setupRecyclerView()
	}

	private fun setupRecyclerView() {
		val adapter = PinDigitAdapter(numberOfDigits)
		val layoutManager =
			NonScrolleableLinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

		rv_pin_digit.addItemDecoration(EqualSpaceItemDecoration(50))
		rv_pin_digit.layoutManager = layoutManager
		layoutManager.setScrollEnabled(false)
		rv_pin_digit.adapter = adapter
		adapter.notifyDataSetChanged()
	}

	/**
	 * TODO doc.
	 */
	class PinDigitAdapter(var digitsCount: Int) :
		RecyclerView.Adapter<PinDigitAdapter.PinDigitHolder>() {

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinDigitHolder {
			val itemView = LayoutInflater.from(parent.context)
				.inflate(R.layout.item_pin_digit, parent, false)
			return PinDigitAdapter.PinDigitHolder(itemView)
		}

		override fun getItemCount(): Int {
			return digitsCount
		}

		override fun onBindViewHolder(holder: PinDigitHolder, position: Int) {

		}

		class PinDigitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		}
	}

	/**
	 * TODO
	 */
	internal inner class EqualSpaceItemDecoration(private val mSpaceHeight: Int) :
		RecyclerView.ItemDecoration() {

		override fun getItemOffsets(
			outRect: Rect, view: View, parent: RecyclerView,
			state: RecyclerView.State
		) {
			view.setBackgroundColor(Color.CYAN)
			outRect.left = mSpaceHeight
			outRect.right = mSpaceHeight
		}
	}

	/**
	 * TODO
	 */
	inner class NonScrolleableLinearLayoutManager(context: Context, a: Int, b: Boolean) :
		LinearLayoutManager(context, a, b) {
		private var isScrollEnabled = true

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

}
