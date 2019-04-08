package com.matias.cogui.common.views

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import com.matias.cogui.R
import com.matias.cogui.common.utils.PinDigitBoxItemDecoration
import com.matias.cogui.common.utils.adapters.PinDigitBoxAdapter
import com.matias.cogui.common.utils.managers.NonScrollableLinearLayoutManager
import kotlinx.android.synthetic.main.view_pin_validator.view.*

/**
 * TODO: document your custom view class.
 */
class PinValidatorView : LinearLayout {

	// Number of pin digits. Default 4.
	private var _numberOfDigits: Int = context.resources.getInteger(R.integer.four)

	/**
	 * In the example view, this dimension is the font size.
	 */
	var numberOfDigits: Int
		get() = _numberOfDigits
		set(value) {
			_numberOfDigits = value
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
		// Load number of digits attribute. Default = 4.
		_numberOfDigits = a.getInt(
			R.styleable.PinValidatorView_numberOfDigits,
			numberOfDigits
		)

		a.recycle()

		// Setup pin digits.
		setupRecyclerView()
	}

	/**
	 * Setup the recycler view.
	 */
	private fun setupRecyclerView() {
		rv_pin_digit?.viewTreeObserver?.addOnGlobalLayoutListener(
			object : ViewTreeObserver.OnGlobalLayoutListener {
				override fun onGlobalLayout() {
					val rvWidth = rv_pin_digit?.measuredWidth

					if (rvWidth != 0) {
						// Item decorator.
						rv_pin_digit.addItemDecoration(
							PinDigitBoxItemDecoration(
								getItemLeftSpace(
									rvWidth!!
								)
							)
						)
						// Layout manager.
						rv_pin_digit.layoutManager = NonScrollableLinearLayoutManager(
							context,
							LinearLayoutManager.HORIZONTAL,
							false
						).apply { setScrollEnabled(false) }
						rv_pin_digit.adapter = PinDigitBoxAdapter(numberOfDigits)
						(rv_pin_digit.adapter as PinDigitBoxAdapter).notifyDataSetChanged()

						rv_pin_digit?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
					}
				}
			})
	}

	/**
	 * Calculate the left space that each pin digit box container should have to occupies
	 * the entire recycler view width without margins at the sides.
	 *
	 * @param rvWidth The recycler view width in PX.
	 *
	 * @return Left space between items in PX.
	 */
	private fun getItemLeftSpace(rvWidth: Int): Int {
		val pinDigitBoxesWidth: Int = numberOfDigits * context.resources.getDimensionPixelSize(
			R.dimen.pin_digit_box
		)
		return (rvWidth - pinDigitBoxesWidth) / (numberOfDigits - 1)
	}

}