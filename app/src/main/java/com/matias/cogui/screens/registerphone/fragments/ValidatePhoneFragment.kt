package com.matias.cogui.screens.registerphone.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.matias.cogui.R

class ValidatePhoneFragment : Fragment() {

	private var listener: Listener? = null

	companion object {
		@JvmStatic
		fun newInstance() =
			ValidatePhoneFragment().apply {
				arguments = Bundle().apply {
				}
			}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		arguments?.let {
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_validate_phone, container, false)
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		if (context is Listener) {
			listener = context
		} else {
			throw RuntimeException("$context must implement ValidatePhoneFragment.Listener interface.")
		}
	}

	override fun onDetach() {
		super.onDetach()
		listener = null
	}

	/**
	 * Interface to be implemented by calling Activity.
	 */
	interface Listener {
		fun onFragmentInteraction()
	}

}
