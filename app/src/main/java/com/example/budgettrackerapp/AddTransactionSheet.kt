package com.example.budgettrackerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup

class AddTransactionSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.bottom_sheet_add_transaction, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<MaterialButtonToggleGroup>(R.id.toggle_type).check(R.id.btn_expense)

        val amount = view.findViewById<EditText>(R.id.et_amount)
        amount.requestFocus()
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)

        view.findViewById<MaterialButton>(R.id.btn_save).setOnClickListener {
            Toast.makeText(requireContext(), "Saved (mock)", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}
