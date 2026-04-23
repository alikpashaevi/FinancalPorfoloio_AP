package com.ap.vi.portfolio

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class AnalyticsFragment : Fragment() {

    private lateinit var tvResult: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_analytics, container, false)
        tvResult = view.findViewById(R.id.ap_vi_tv_result)

        parentFragmentManager.setFragmentResultListener("savings_data", viewLifecycleOwner) { _, bundle ->
            val savings = bundle.getDouble("savings")
            tvResult.text = "Final Savings: $savings"
        }

        return view
    }
}