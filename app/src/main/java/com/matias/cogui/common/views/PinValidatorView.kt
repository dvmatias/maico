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
import android.view.ViewTreeObserver
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

		setRecyclerViewWidth()

	}

	private fun setRecyclerViewWidth() {
		rv_pin_digit?.viewTreeObserver?.addOnGlobalLayoutListener(
			object : ViewTreeObserver.OnGlobalLayoutListener {
				override fun onGlobalLayout() {
					rv_pin_digit?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
					val rvWidth = rv_pin_digit?.measuredWidth

					if (rvWidth != 0) {
						val adapter = PinDigitAdapter(numberOfDigits)
						val layoutManager =
							NonScrollableLinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

						rv_pin_digit.addItemDecoration(EqualSpaceItemDecoration((rvWidth!! - numberOfDigits*context.resources.getDimensionPixelSize(R.dimen.dimen_38dp)) / (numberOfDigits-1)))

						rv_pin_digit.layoutManager = layoutManager
						layoutManager.setScrollEnabled(false)
						rv_pin_digit.adapter = adapter
						adapter.notifyDataSetChanged()

					}
				}
			})
	}


	/**
	 * TODO doc.
	 */
	class PinDigitAdapter(var digitsCount: Int) :
		RecyclerView.Adapter<PinDigitAdapter.PinDigitHolder>() {

		private var recyclerView: RecyclerView? = null
		private var recyclerViewWidth: Int? = 0

		override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
			super.onAttachedToRecyclerView(recyclerView)

			this.recyclerView = recyclerView
		}

		override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinDigitHolder {
			val itemView = LayoutInflater.from(parent.context)
				.inflate(R.layout.item_pin_digit, parent, false)
			return PinDigitAdapter.PinDigitHolder(itemView)
		}

		override fun getItemCount(): Int {
			return digitsCount
		}

		override fun onBindViewHolder(holder: PinDigitHolder, position: Int) {
			// Set a tag to keep track of item inside [EqualSpaceItemDecoration] decorator.
			holder.itemView.tag = "$position"
		}

		class PinDigitHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		}

	}

	/**
	 * TODO
	 */
	open class EqualSpaceItemDecoration(private val mSpaceHeight: Int) :
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

	/**
	 * TODO
	 */
	inner class NonScrollableLinearLayoutManager(context: Context, a: Int, b: Boolean) :
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

private fun PinValidatorView.EqualSpaceItemDecoration.caca(i: Int) {

}
