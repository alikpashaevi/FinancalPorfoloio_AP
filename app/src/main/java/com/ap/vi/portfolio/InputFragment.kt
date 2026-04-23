package com.ap.vi.portfolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class InputFragment : Fragment() {

    private lateinit var etIncome: EditText
    private lateinit var etExpenses: EditText
    private lateinit var btnSave: Button
    private val wealthManager = WealthManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, container, false)

        etIncome = view.findViewById(R.id.ap_vi_et_income)
        etExpenses = view.findViewById(R.id.ap_vi_et_expenses)
        btnSave = view.findViewById(R.id.ap_vi_btn_save)

        btnSave.setOnClickListener {
            if (validateInput()) {
                val income = etIncome.text.toString().toDouble()
                val expenses = etExpenses.text.toString().toDouble()
                val savings = wealthManager.calculateSavings(income, expenses)

                parentFragmentManager.setFragmentResult(
                    "savings_data",
                    bundleOf("savings" to savings)
                )

                Toast.makeText(context, "Calculated and Saved!", Toast.LENGTH_SHORT).show()
                etIncome.text.clear()
                etExpenses.text.clear()
            }
        }

        return view
    }

    private fun validateInput(): Boolean {
        var isValid = true
        if (etIncome.text.isEmpty()) {
            etIncome.error = "Field cannot be empty"
            isValid = false
        }
        if (etExpenses.text.isEmpty()) {
            etExpenses.error = "Field cannot be empty"
            isValid = false
        }
        return isValid
    }
}