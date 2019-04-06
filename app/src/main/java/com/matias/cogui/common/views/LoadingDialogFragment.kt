package com.matias.cogui.common.views

import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.matias.cogui.R
import android.util.DisplayMetrics
import android.view.WindowManager



class LoadingDialogFragment : DialogFragment() {

	companion object {
		@JvmStatic
		fun newInstance() = LoadingDialogFragment()

		val TAG: String
			get() {
				val tag = LoadingDialogFragment::class.java.simpleName
				return if (tag.length <= 23) tag else tag.substring(0, 23)
			}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_loading, container, false)
	}

	override fun onResume() {
		super.onResume()
		val wm = context?.applicationContext?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
		val display = wm.defaultDisplay
		val metrics = DisplayMetrics()
		display.getMetrics(metrics)
		val widthDisplay = metrics.widthPixels

		val width = widthDisplay * 0.8
		val height = LinearLayout.LayoutParams.WRAP_CONTENT
		dialog.window!!.setLayout(width.toInt(), height)
	}
}
