package com.matias.cogui.screens.registerphone

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.matias.cogui.R
import com.matias.cogui.common.model.objects.Country
import com.matias.cogui.common.mvp.BaseFragment
import com.matias.cogui.common.utils.ImageLoader
import com.matias.cogui.common.utils.managers.PhoneManager
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_enter_phone.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class EnterPhoneFragment : BaseFragment(), View.OnClickListener {

	@Inject
	lateinit var imageLoader: ImageLoader
	@Inject
	lateinit var phoneManager: PhoneManager

	private var param1: String? = null
	private var param2: String? = null
	private var listener: OnFragmentInteractionListener? = null
	private var isAgreementViewVisible: Boolean = false

	override fun onClick(v: View?) {
		when (v?.id) {
			btn_get_started.id -> listener?.onGetStartedClick(v_country_phone_selector.phoneNumber)
		}
	}

	companion object {
		@JvmStatic
		fun newInstance(args: Bundle?) =
			EnterPhoneFragment().apply {
				args?.apply {
					putString(ARG_PARAM1, param1)
					putString(ARG_PARAM2, param2)
				}
			}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		getPresentationComponent().inject(this)

		arguments?.let {
			param1 = it.getString(ARG_PARAM1)
			param2 = it.getString(ARG_PARAM2)
		}
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_enter_phone, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		btn_get_started.setOnClickListener(this)
	}

	override fun onAttach(context: Context) {
		super.onAttach(context)
		if (context is OnFragmentInteractionListener) {
			listener = context
		} else {
			throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
		}
	}

	override fun onDetach() {
		super.onDetach()
		listener = null
	}

	interface OnFragmentInteractionListener {
		fun onGetStartedClick(phoneNumber: String)
		fun goToChooseCountryScreen()
	}

	/**
	 * TODO
	 */

	fun showGetStartButton(show: Boolean) {
		btn_get_started.visibility = if (show) View.VISIBLE else View.GONE
	}

	fun showTermsAndConditions(show: Boolean) {
		if (isAgreementViewVisible == show) return
		isAgreementViewVisible = show
		if (show) agreement_view.setChecked(!show)
		agreement_view.visibility = if (show) View.VISIBLE else View.GONE
	}

	fun showSelectedCountry(selectedCountry: Country) {
		v_country_phone_selector.showCountryInfo(selectedCountry, imageLoader, phoneManager)
	}

}